package org.digitalmodular.wadapi;

import static org.digitalmodular.utilities.ValidatorUtilities.requireStringLengthAtLeast;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public enum GameType {
	ACTION2("Action2"),
	CHEX("Chex"),
	CHEX3("Chex3"),
	DOOM("Doom"),
	DOOM2("Doom2"),
	HARMONY("Harmony"),
	HERETIC("Heretic"),
	HEXEN("Hexen"),
	STRIFE("Strife");

	private final String name;

	GameType(String name) {
		this.name = requireStringLengthAtLeast(1, name, "name");
	}

	public String getName() {
		return name;
	}
}
