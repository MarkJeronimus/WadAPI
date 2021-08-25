package org.digitalmodular.wadapi.resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import org.digitalmodular.udbconfigreader.ConfigStruct;
import org.digitalmodular.udbconfigreader.GameConfigurationIO;

/**
 * Wraps a ConfigStruct loaded from a game configuration file,
 * and provides a convenient high-level interface to work with.
 *
 * @author Zom-B
 */
// Created 2021-08-17
public class GameResources {
	private final ThingsResource things;

	public static void main(String... args) throws IOException {
		for (Path file : Files.newDirectoryStream(Paths.get("Configurations/")))
			if (!Files.isDirectory(file))
				new GameResources(GameConfigurationIO.loadGameConfiguration(file));

//		ConfigStruct entries =
//				GameConfigurationIO.loadGameConfiguration(Paths.get("Configurations/Includes/Common.cfg"));
//		System.out.println(entries.getStruct("thingtypes"));
//		new GameResources(entries);
	}

	public GameResources(ConfigStruct gameConfig) {
		requireNonNull(gameConfig, "gameConfig");

		String type = gameConfig.getString("type", "");
		if (!type.equals("Doom Builder 2 Game Configuration")) {
			if (type.isEmpty())
				throw new IllegalArgumentException("Not a Doom Builder 2 Game Configuration");
			else
				throw new IllegalArgumentException("Not a Doom Builder 2 Game Configuration: \"" + type + '"');
		}

		things = new ThingsResource(gameConfig);
	}

	public @Nullable ThingData getThing(int type) {
		requireAtLeast(0, type, "type");

		return things.getThing(type);
	}

	public ThingCategory getThingCategory(ThingData thingData) {
		requireNonNull(thingData, "thingData");

		ThingCategory category = things.getCategory(thingData.getCategoryName());
		assert category != null : thingData;
		return category;
	}
}
