package org.digitalmodular.wadapi.io;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import org.digitalmodular.wadapi.WadFile;
import org.digitalmodular.wadapi.WadStorage;
import org.digitalmodular.wadapi.lump.Lump;

/**
 * @author Zom-B
 */
// Created 2021-08-02
public class LumpPointer {
	private final WadStorage wadStorage;
	private final int        wadIndex;
	private final int        lumpIndex;

	public LumpPointer(WadStorage wadStorage, int wadIndex, int lumpIndex) {
		this.wadStorage = requireNonNull(wadStorage, "wadStorage");
		this.wadIndex = requireAtLeast(0, wadIndex, "wadIndex");
		this.lumpIndex = requireAtLeast(0, lumpIndex, "mapLumpIndex");
	}

	public WadStorage getWadStorage() {
		return wadStorage;
	}

	public int getWadIndex() {
		return wadIndex;
	}

	public int getLumpIndex() {
		return lumpIndex;
	}

	public WadFile getWadFile() {
		return wadStorage.getWad(wadIndex);
	}

	public Lump getLump() {
		return wadStorage.getWad(wadIndex).get(lumpIndex);
	}

	public void setLump(Lump lump) {
		wadStorage.getWad(wadIndex).set(lumpIndex, lump);
	}

	@Contract("null -> null; !null -> !null")
	public static @Nullable Lump getNullableLump(@Nullable LumpPointer pointer) {
		return pointer == null ? null : pointer.getLump();
	}

	public LumpPointer withLumpIndex(int mapIndex) {
		return new LumpPointer(getWadStorage(), getWadIndex(), mapIndex);
	}

	@Override
	public String toString() {
		return "wadStorage.getWad(" + wadIndex + ").get(" + lumpIndex + ')';
	}
}
