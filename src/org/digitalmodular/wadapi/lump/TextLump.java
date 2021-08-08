package org.digitalmodular.wadapi.lump;

import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;

import org.digitalmodular.wadapi.LumpType;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class TextLump extends Lump {
	private final StringBuilder text;

	public TextLump(String name, LumpType lumpType, int initialCapacity) {
		super(name, lumpType);

		text = new StringBuilder(requireAtLeast(1, initialCapacity, "initialCapacity"));
	}

	public StringBuilder getText() {
		return text;
	}
}
