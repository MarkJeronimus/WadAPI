package org.digitalmodular.wadapi;

import org.digitalmodular.utilities.ValidatorUtilities;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public enum MapFormat {
	DOOM("Doom"),
	HEXEN("Hexen"),
	UDMF("UDMF");

	private final String name;

	MapFormat(String name) {
		this.name = ValidatorUtilities.requireStringLengthAtLeast(1, name, "name");
	}

	public String getName() {
		return name;
	}
}
