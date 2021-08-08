package org.digitalmodular.wadapi.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Zom-B
 */
// Created 2018-01-20
public class InfoTable implements Iterable<InfoTableEntry> {
	private final List<InfoTableEntry> infoTable;

	public InfoTable(int initialCapacity) {
		infoTable = new ArrayList<>(initialCapacity);
	}

	public int numLumps() {
		return infoTable.size();
	}

	public boolean add(InfoTableEntry entry) {
		return infoTable.add(entry);
	}

	@Override
	public Iterator<InfoTableEntry> iterator() {
		return infoTable.iterator();
	}
}
