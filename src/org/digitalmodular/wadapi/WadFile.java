package org.digitalmodular.wadapi;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import org.digitalmodular.wadapi.lump.Lump;

/**
 * @author Zom-B
 */
// Created 2011-08-01
public class WadFile implements Iterable<Lump> {
	private final WadType    wadType;
	private final List<Lump> lumps;

	private @Nullable Path file = null;

	public WadFile(WadType wadType, int initialCapacity) {
		this.wadType = requireNonNull(wadType, "wadType");
		lumps = new ArrayList<>(requireAtLeast(0, initialCapacity, "initialCapacity"));
	}

	public WadType getWadType() {
		return wadType;
	}

	public @Nullable Path getFile() {
		return file;
	}

	public void setFile(@Nullable Path file) {
		this.file = file;
	}

	public int numLumps() {
		return lumps.size();
	}

	public boolean isEmpty() {
		return lumps.isEmpty();
	}

	public void add(Lump lump) {
		lumps.add(lump);
	}

	public void addAll(WadFile wadFile) {
		lumps.addAll(wadFile.lumps);
	}

	public void clear() {
		lumps.clear();
	}

	public Lump get(int i) {
		return lumps.get(i);
	}

	public Lump set(int index, Lump element) {
		return lumps.set(index, element);
	}

	public void add(int index, Lump element) {
		lumps.add(index, element);
	}

	public Lump remove(int index) {
		return lumps.remove(index);
	}

	public @Nullable Lump get(String name) {
		for (int i = lumps.size() - 1; i >= 0; i--)
			if (lumps.get(i).getName().equals(name))
				return lumps.get(i);

		return null;
	}

	public int indexOf(String name) {
		for (int i = lumps.size() - 1; i >= 0; i--)
			if (lumps.get(i).getName().equals(name))
				return i;

		return -1;
	}

	@Override
	public Iterator<Lump> iterator() {
		return lumps.iterator();
	}
}
