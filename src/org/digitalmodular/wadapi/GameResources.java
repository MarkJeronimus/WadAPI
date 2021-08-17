package org.digitalmodular.wadapi;

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
	private final ConfigStruct configStruct;

	public GameResources(ConfigStruct configStruct) {
		this.configStruct = requireNonNull(configStruct, "configStruct");

		String type = configStruct.getString("type", "");
		if (!type.equals("Doom Builder 2 Game Configuration")) {
			if (type.isEmpty())
				throw new IllegalArgumentException("Not a Doom Builder 2 Game Configuration");
			else
				throw new IllegalArgumentException("Not a Doom Builder 2 Game Configuration: \"" + type + '"');
		}
	}

	public String getThingName(int type) {
		return "unknown";
	}
}
