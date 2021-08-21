package org.digitalmodular.wadapi.resources;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import org.digitalmodular.udbconfigreader.ConfigStruct;

/**
 * Wraps a ConfigStruct loaded from a game configuration file,
 * and provides a convenient high-level interface to work with.
 *
 * @author Zom-B
 */
// Created 2021-08-17
public class GameResources {
	private final ThingsResource things;

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

		return things.get(type);
	}
}
