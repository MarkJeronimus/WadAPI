package org.digitalmodular.wadapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.digitalmodular.utilities.annotation.UtilityClass;

import org.digitalmodular.udbconfigreader.ConfigStruct;
import org.digitalmodular.udbconfigreader.GameConfigurationIO;

/**
 * @author Zom-B
 */
// Created 2021-08-16
@UtilityClass
public final class GameConfigurationLoader {
	private GameConfigurationLoader() {
		throw new AssertionError();
	}

	public static ConfigStruct loadGameConfiguration(SourcePort sourceport, GameType gameType, MapFormat mapFormat)
			throws IOException {
		Path file = Paths.get("Configurations/" + sourceport.getName() +
		                      '_' + gameType.getName() + mapFormat.getName() + ".cfg");

		if (!Files.exists(file))
			throw new IllegalArgumentException("Configuration file for the specified combination doesn't exist: " +
			                                   file);

		return GameConfigurationIO.loadGameConfiguration(file);
	}
}
