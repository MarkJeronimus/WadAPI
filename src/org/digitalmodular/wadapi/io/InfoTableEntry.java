package org.digitalmodular.wadapi.io;

import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;
import static org.digitalmodular.utilities.ValidatorUtilities.requireStringLengthBetween;

/**
 * @author Zom-B
 */
// Created 2018-01-20
public class InfoTableEntry {
	public static final int INFO_TABLE_ENTRY_SIZE = 8;

	private final int    offset;
	private final int    length;
	private final String name;

	public InfoTableEntry(int offset, int length, String name) {
		this.offset = requireAtLeast(0, offset, "offset");
		this.length = requireAtLeast(0, length, "offset");
		this.name = requireStringLengthBetween(1, 8, name, "name");
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + '[' + name + ']';
	}
}
