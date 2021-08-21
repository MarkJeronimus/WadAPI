package org.digitalmodular.wadapi.resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

	public GameResources(ConfigStruct configStruct) {
		requireNonNull(configStruct, "configStruct");

		String type = configStruct.getString("type", "");
		if (!type.equals("Doom Builder 2 Game Configuration")) {
			if (type.isEmpty())
				throw new IllegalArgumentException("Not a Doom Builder 2 Game Configuration");
			else
				throw new IllegalArgumentException("Not a Doom Builder 2 Game Configuration: \"" + type + '"');
		}

		things = new ThingsResource(configStruct);
	}

	public ThingData getThing(int type) {
		return things.get(type);
	}
}
