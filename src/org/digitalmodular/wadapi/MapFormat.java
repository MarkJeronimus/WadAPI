package org.digitalmodular.wadapi;

import static org.digitalmodular.utilities.ValidatorUtilities.requireStringLengthAtLeast;

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
		this.name = requireStringLengthAtLeast(1, name, "name");
	}

	public String getName() {
		return name;
	}
}
