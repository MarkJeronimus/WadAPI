package org.digitalmodular.wadapi;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import org.digitalmodular.wadapi.codec.MapCodec;
import org.digitalmodular.wadapi.io.LumpPointer;
import org.digitalmodular.wadapi.io.MapPointers;
import org.digitalmodular.wadapi.io.MapPointersBuilder;
import org.digitalmodular.wadapi.io.WadFileIO;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.Lump;

/**
 * @author Zom-B
 */
// Created 2013-09-15
public class WadStorage implements Iterable<WadFile> {
	private final List<WadFile> wadFiles = new ArrayList<>(8);

	public int numWadFiles() {
		return wadFiles.size();
	}

	private boolean containsIWAD() {
		return !wadFiles.isEmpty() && wadFiles.get(0).getWadType() == WadType.IWAD;
	}

	public @Nullable WadFile getIWAD() {
		return containsIWAD() ? wadFiles.get(0) : null;
	}

	public void removeIWAD() {
		if (containsIWAD())
			wadFiles.remove(0);
	}

	/**
	 * When loading an IWAD, it's automatically placed at the beginning. When reloading a PWAD, it's automatically
	 * moved to the end.
	 * <p>
	 * Loading is performed before unloading the duplicate from this list, to prevent unloading in case of load error.
	 * For better memory performance, manually remove the file first.
	 */
	public void add(Path file) throws IOException {
		file = requireNonNull(file, "file").toRealPath();

		WadFile wad    = WadFileIO.read(file);
		boolean isIwad = wad.getWadType() == WadType.IWAD;

		remove(file);

		if (isIwad) {
			removeIWAD();
			wadFiles.add(0, wad);
		} else {
			wadFiles.add(wad);
		}
	}

	public @Nullable WadFile get(Path file) throws IOException {
		Path finalFile = requireNonNull(file, "file").toRealPath();

		return wadFiles.stream()
		               .filter(wad -> finalFile.equals(wad.getFile()))
		               .findAny()
		               .orElse(null);
	}

	public boolean contains(Path file) throws IOException {
		return get(file) != null;
	}

	public void remove(Path file) throws IOException {
		Path finalFile = requireNonNull(file, "file").toRealPath();

		wadFiles.removeIf(wad -> finalFile.equals(wad.getFile()));
	}

	public WadFile getWad(int wadIndex) {
		if (wadFiles.isEmpty())
			throw new IllegalStateException("No wad added");

		return wadFiles.get(wadIndex);
	}

	public WadFile getLatestWad() {
		return wadFiles.get(wadFiles.size() - 1);
	}

	public void saveAs(Path file) throws IOException {
		file = requireNonNull(file, "file").toRealPath();

		WadFile wad = wadFiles.get(wadFiles.size() - 1);

		WadFile overwritingWad = get(file);
		//noinspection ObjectEquality
		if (wad == overwritingWad)
			throw new IllegalArgumentException(
					"Can't save the last WAD under the same filename as a different loaded WAD");

		WadFileIO.write(wad, file);
		wad.setFile(file);
	}

	private int overestimatedLumpCount() {
		int count = 0;

		for (WadFile wad : wadFiles)
			count += wad.numLumps();

		return count;
	}

	public @Nullable Lump getLump(String name) {
		for (int i = wadFiles.size() - 1; i >= 0; i--) {
			WadFile wadFile = wadFiles.get(i);

			int lumpIndex = wadFile.indexOf(name);
			if (lumpIndex < 0)
				continue;

			Lump lump = wadFile.get(lumpIndex);
			assert lump != null : wadFile.getFile() + ": " + name + " @ " + lumpIndex;

			if (lump instanceof FileBufferLump) {
				lump = LumpUtilities.decodeLump(lump);
				wadFile.set(lumpIndex, lump);
			}

			return lump;
		}

		return null;
	}

	/**
	 * Returns the lumps from the wads in reverse order: Lumps from the last added wad first.
	 */
	public List<String> getAllLumpsByType(LumpType type) {
		int maxLumps = overestimatedLumpCount();

		Collection<String> lumpNames = new HashSet<>(maxLumps);

		for (int i = wadFiles.size() - 1; i >= 0; i--) {
			WadFile wad = wadFiles.get(i);
			for (Lump lump : wad) {
				if (lump.getLumpType() != type)
					continue;

				String name = lump.getName();
				if (lumpNames.contains(name))
					continue;

				lumpNames.add(name);
			}
		}

		List<String> sortedNames = new ArrayList<>(lumpNames);
		Collections.sort(sortedNames);
		return sortedNames;
	}

	public @Nullable WadMap getMap(String mapName) {
		for (int wadIndex = wadFiles.size() - 1; wadIndex >= 0; wadIndex--) {
			WadFile wadFile = wadFiles.get(wadIndex);

			for (int lumpIndex = 0; lumpIndex < wadFile.numLumps(); lumpIndex++) {
				Lump lump = wadFile.get(lumpIndex);
				if (lump.getLumpType() != LumpType.MAP || !lump.getName().equals(mapName))
					continue;

				MapPointers      mapPointers = getMapPointers(new LumpPointer(this, wadIndex, lumpIndex));
				@Nullable WadMap map         = MapCodec.makeMap(mapPointers);
				if (map != null)
					return map;
			}
		}

		Thread.yield();
		return null;
	}

	private static MapPointers getMapPointers(LumpPointer mapTagPointer) {
		MapPointersBuilder mapPointersBuilder = new MapPointersBuilder(mapTagPointer);

		WadFile wadFile = mapTagPointer.getWadFile();

		for (int lumpIndex = mapTagPointer.getLumpIndex() + 1; lumpIndex < wadFile.numLumps(); lumpIndex++) {
			Lump lump = wadFile.get(lumpIndex);
			if (!LumpType.isMapLump(lump.getLumpType()))
				break;

			mapPointersBuilder.addMapLump(mapTagPointer.withLumpIndex(lumpIndex));
		}

		return mapPointersBuilder.build();
	}

	@Override
	public Iterator<WadFile> iterator() {
		return wadFiles.iterator();
	}
}
