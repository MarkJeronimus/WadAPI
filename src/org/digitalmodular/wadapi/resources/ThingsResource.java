package org.digitalmodular.wadapi.resources;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jetbrains.annotations.Nullable;

import org.digitalmodular.utilities.annotation.StaticClass;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import org.digitalmodular.udbconfigreader.ConfigStruct;

/**
 * @author Zom_B
 */
// Created 2021-08-18
@StaticClass
public class ThingsResource {
	private final Set<String>             categories = new HashSet<>(64);
	private final Map<Integer, ThingData> things     = new HashMap<>(1024);

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
			categories.add(category);

			parseThingCategory(gameConfig, category);
		}

		categories.add("decorate");
	}

	private void parseThingCategory(ConfigStruct configStruct, String category) {
		ConfigStruct thingTypes = configStruct.getStruct("thingtypes");
		assert thingTypes != null;

		@Nullable ConfigStruct entries = thingTypes.getStruct(category);
		if (entries == null)
			throw new IllegalArgumentException("\"thingtypes." + category + "\" is not a structure");

		ThingCategoryBuilder categoryTemplate = new ThingCategoryBuilder();
		ThingDataBuilder     thingTemplate    = new ThingDataBuilder();

		String structPath = "thingtypes." + category + '.';

		for (Map.Entry<String, Object> entry : entries)
			parseCategoryEntry(structPath, entry, categoryTemplate, thingTemplate);
	}

	private void parseCategoryEntry(String structPath,
	                                Map.Entry<String, Object> entry,
	                                ThingCategoryBuilder categoryTemplate,
	                                ThingDataBuilder thingTemplate) {
		String key = entry.getKey();

		switch (key) {
			// @formatter:off
			case "sort" : categoryTemplate.setSorted(parseInt   (structPath, entry)); return;
			case "title": categoryTemplate.setTitle (parseString(structPath, entry)); return;
			// @formatter:on
			default:
		}

		boolean thingEntryParsed = tryParseThingEntry(structPath, entry, thingTemplate);
		if (thingEntryParsed)
			return;

		try {
			int id = Integer.parseInt(key);
			parseThingData(structPath, id, entry.getValue(), categoryTemplate, thingTemplate);
		} catch (NumberFormatException ignored) {
			throw new IllegalArgumentException('"' + structPath + key + "\" is unrecognized");
		}
	}

	private void parseThingData(String structPath,
	                            int id,
	                            Object thingData,
	                            ThingCategoryBuilder categoryTemplate,
	                            ThingDataBuilder thingTemplate) {

		if (thingData == null) {
			// Thing defined by one include and subsequently removed by another.
			return;
		} else if (thingData instanceof String) {
			parseStringDataAsString(structPath,
			                        id,
			                        (String)thingData,
			                        categoryTemplate,
			                        thingTemplate);
			return;
		} else if (thingData instanceof ConfigStruct) {
			parseStringDataAsStruct(structPath,
			                        id,
			                        (ConfigStruct)thingData,
			                        categoryTemplate,
			                        thingTemplate);
			return;
		}

		throw new IllegalArgumentException("Value of \"" + structPath + id + "\" is not a string or a structure: " +
		                                   thingData);
	}

	private void parseStringDataAsString(String structPath,
	                                     int id,
	                                     String title,
	                                     ThingCategoryBuilder categoryTemplate,
	                                     ThingDataBuilder thingTemplate) {
		if (title.isEmpty())
			throw new IllegalArgumentException('"' + structPath + id + "\" is empty");

		ThingData thing = thingTemplate.build(id, categoryTemplate.getTitle(), title);
		things.put(id, thing);
	}

	private void parseStringDataAsStruct(String structPath,
	                                     int id,
	                                     ConfigStruct thingData,
	                                     ThingCategoryBuilder categoryTemplate,
	                                     ThingDataBuilder thingTemplate) {
		structPath += id + ".";

		@Nullable String title = null;

		for (Map.Entry<String, Object> entry : thingData) {
			boolean thingEntryParsed = tryParseThingEntry(structPath, entry, thingTemplate);
			if (thingEntryParsed)
				continue;

			if (entry.getKey().equals("title")) {
				title = parseString(structPath, entry);
				continue;
			}

			throw new IllegalArgumentException('"' + structPath + entry.getKey() + "\" is unrecognized");
		}

		if (title == null)
			throw new IllegalArgumentException('"' + structPath + "title\" is missing");
		if (title.isEmpty())
			throw new IllegalArgumentException('"' + structPath + "title\" is empty");

		ThingData thing = thingTemplate.build(id, categoryTemplate.getTitle(), title);
		things.put(id, thing);
	}

	@SuppressWarnings("SpellCheckingInspection")
	private static boolean tryParseThingEntry(
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

	public ThingData get(Integer id) {
		requireNonNull(id, "id");

		return things.get(id);
	}
}
