package org.digitalmodular.wadapi.resources;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import org.digitalmodular.utilities.annotation.StaticClass;
import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;
import static org.digitalmodular.utilities.ValidatorUtilities.requireStringLengthAtLeast;

import org.digitalmodular.udbconfigreader.ConfigStruct;

/**
 * @author Zom_B
 */
// Created 2021-08-18
@StaticClass
public class ThingsResource {
	private final Map<String, ThingCategoryBuilder> categories = new LinkedHashMap<>(64);
	private final Map<Integer, ThingData>           things     = new HashMap<>(1024);

	public ThingsResource(ConfigStruct gameConfig) {
		requireNonNull(gameConfig, "gameConfig");

		@Nullable ConfigStruct thingTypes = gameConfig.getStruct("thingtypes");
		if (thingTypes == null) {
			if (gameConfig.get("thingtypes") != null)
				throw new IllegalArgumentException("\"thingtypes\" is not a structure");
			else
				throw new IllegalArgumentException("\"thingtypes\" structure is missing ");
		}

		for (Map.Entry<String, Object> thingType : thingTypes) {
			String category = thingType.getKey();

			@Nullable ConfigStruct entries = thingTypes.getStruct(category);
			if (entries == null)
				throw new IllegalArgumentException("\"thingtypes." + category + "\" is not a structure");

			parseThingCategory(entries);
		}
	}

	private void parseThingCategory(ConfigStruct entries) {
		String categoryName = entries.getName();
		ThingCategoryBuilder categoryTemplate = categories.computeIfAbsent(
				categoryName, ignored -> new ThingCategoryBuilder(categoryName));

		ThingDataBuilder thingTemplate = new ThingDataBuilder();

		String structPath = "thingtypes." + categoryName + '.';

		for (Map.Entry<String, Object> entry : entries)
			parseCategoryEntry(structPath, entry, categoryTemplate, thingTemplate);
	}

	private void parseCategoryEntry(String structPath,
	                                Map.Entry<String, Object> entry,
	                                ThingCategoryBuilder categoryTemplate,
	                                ThingDataBuilder thingTemplate) {
		boolean parsed = tryParseThingCategoryProperty(structPath, entry, categoryTemplate);
		if (parsed)
			return;

		parsed = tryParseThingProperty(structPath, entry, thingTemplate);
		if (parsed)
			return;

		parseThing(structPath, entry, categoryTemplate, thingTemplate);
	}

	private static boolean tryParseThingCategoryProperty(
			String structPath, Map.Entry<String, Object> entry, ThingCategoryBuilder categoryTemplate) {
		switch (entry.getKey()) {
			// @formatter:off
			case "title": categoryTemplate.setTitle (parseString(structPath, entry)); return true;
			case "sort" : categoryTemplate.setSorted(parseInt   (structPath, entry)); return true;
			// @formatter:on
			default:
		}
		return false;
	}

	@SuppressWarnings("SpellCheckingInspection")
	private static boolean tryParseThingProperty(
			String structPath, Map.Entry<String, Object> entry, ThingDataBuilder thingTemplate) {
		switch (entry.getKey()) {
			// @formatter:off
			case "sprite"       : thingTemplate.setSprite       (parseString (structPath, entry)); return true;
			case "color"        : thingTemplate.setColor        (parseInt    (structPath, entry)); return true;
			case "alpha"        : thingTemplate.setAlpha        (parseFloat  (structPath, entry)); return true;
			case "renderstyle"  : thingTemplate.setRenderStyle  (parseString (structPath, entry)); return true;
			case "arrow"        : thingTemplate.setArrow        (parseInt    (structPath, entry)); return true;
			case "width"        : thingTemplate.setRadius       (parseInt    (structPath, entry)); return true;
			case "height"       : thingTemplate.setHeight       (parseInt    (structPath, entry)); return true;
			case "hangs"        : thingTemplate.setHangs        (parseInt    (structPath, entry)); return true;
			case "blocking"     : thingTemplate.setBlocking     (parseInt    (structPath, entry)); return true;
			case "error"        : thingTemplate.setErrorCheck   (parseInt    (structPath, entry)); return true;
			case "fixedsize"    : thingTemplate.setFixedSize    (parseBoolean(structPath, entry)); return true;
			case "fixedrotation": thingTemplate.setFixedRotation(parseBoolean(structPath, entry)); return true;
			case "absolutez"    : thingTemplate.setAbsoluteZ    (parseBoolean(structPath, entry)); return true;
			case "spritescale"  : thingTemplate.setSpriteScale  (parseFloat  (structPath, entry)); return true;
			case "locksprite"   : thingTemplate.setLockSprite   (parseBoolean(structPath, entry)); return true;
			case "class"        : thingTemplate.setDecorateClass(parseString (structPath, entry)); return true;
			case "flagsrename"  : /* TODO */                                                       return true;
			case "thinglink"    : thingTemplate.setThingLink    (parseInt    (structPath, entry)); return true;
			case "arg0"         : /* TODO */                                                       return true;
			case "arg1"         : /* TODO */                                                       return true;
			case "arg2"         : /* TODO */                                                       return true;
			case "arg3"         : /* TODO */                                                       return true;
			case "arg4"         : /* TODO */                                                       return true;
			case "optional"     : thingTemplate.setOptional     (parseBoolean(structPath, entry)); return true;
			// @formatter:on
			default:
				return false;
		}
	}

	public void parseThing(String structPath,
	                       Map.Entry<String, Object> entry,
	                       ThingCategoryBuilder categoryTemplate,
	                       ThingDataBuilder thingTemplate) {
		try {
			thingTemplate.setId(Integer.parseInt(entry.getKey()));
		} catch (NumberFormatException ignored) {
			throw new IllegalArgumentException('"' + structPath + entry.getKey() + "\" is unrecognized");
		}

		@Nullable Object thingProperties = entry.getValue();
		String           categoryName    = categoryTemplate.getName();
		thingTemplate.setCategoryName(categoryName);

		structPath += entry.getKey();

		if (thingProperties == null) {
			// Thing defined by one include and subsequently removed by another.
			return;
		} else if (thingProperties instanceof String) {
			parseThingFromString(structPath, (String)thingProperties, thingTemplate);
			return;
		} else if (thingProperties instanceof ConfigStruct) {
			parseThingFromStruct(structPath, (ConfigStruct)thingProperties, thingTemplate);
			return;
		}

		throw new IllegalArgumentException("Value of \"" + structPath +
		                                   "\" is not a string or a structure: " + thingProperties);
	}

	private void parseThingFromString(String structPath, String title, ThingDataBuilder thingTemplate) {
		if (title.isEmpty())
			throw new IllegalArgumentException("Value of \"" + structPath + "\" (title) is empty");

		ThingData thing = thingTemplate.build(title);
		things.put(thing.getId(), thing);
	}

	private void parseThingFromStruct(String structPath, ConfigStruct thingData, ThingDataBuilder thingTemplate) {
		@Nullable String title = null;

		for (Map.Entry<String, Object> entry : thingData) {
			boolean thingEntryParsed = tryParseThingProperty(structPath, entry, thingTemplate);
			if (thingEntryParsed)
				continue;

			if (entry.getKey().equals("title")) {
				title = parseString(structPath, entry);
				continue;
			}

			throw new IllegalArgumentException('"' + structPath + '.' + entry.getKey() + "\" is unrecognized");
		}

		if (title == null)
			throw new IllegalArgumentException('"' + structPath + ".title\" is missing");
		if (title.isEmpty())
			throw new IllegalArgumentException('"' + structPath + ".title\" is empty");

		ThingData thing = thingTemplate.build(title);
		things.put(thing.getId(), thing);
	}

	private static String parseString(String structPath, Map.Entry<String, Object> entry) {
		Object value = entry.getValue();
		if (!(value instanceof ConfigStruct))
			return value.toString().toLowerCase();

		throw new IllegalArgumentException("Value of \"" + structPath + entry.getKey() +
		                                   "\" is not a string");
	}

	private static boolean parseBoolean(String structPath, Map.Entry<String, Object> entry) {
		Object value = entry.getValue();
		if (!(value instanceof ConfigStruct)) {
			String string = value.toString().toLowerCase();
			if (string.equals("true"))
				return true;
			else if (string.equals("false"))
				return false;
		}

		throw new IllegalArgumentException("Value of \"" + structPath + entry.getKey() +
		                                   "\" is not a boolean");
	}

	private static int parseInt(String structPath, Map.Entry<String, Object> entry) {
		Object value = entry.getValue();
		if (!(value instanceof ConfigStruct)) {
			try {
				return Integer.parseInt(value.toString());
			} catch (NumberFormatException ignored) {
			}
		}

		throw new IllegalArgumentException("Value of \"" + structPath + entry.getKey() +
		                                   "\" is not an int");
	}

	private static float parseFloat(String structPath, Map.Entry<String, Object> entry) {
		Object value = entry.getValue();
		if (!(value instanceof ConfigStruct)) {
			try {
				return Float.parseFloat(value.toString());
			} catch (NumberFormatException ignored) {
			}
		}

		throw new IllegalArgumentException("Value of \"" + structPath + entry.getKey() +
		                                   "\" is not a float");
	}

	public @Nullable ThingCategory getCategory(String name) {
		requireStringLengthAtLeast(1, name, "name");

		return categories.get(name);
	}

	public @Nullable ThingData getThing(Integer id) {
		requireNonNull(id, "id");
		requireAtLeast(0, id, "id");

		return things.get(id);
	}
}
