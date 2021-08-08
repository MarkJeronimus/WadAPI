package org.digitalmodular.wadapi.lump;

import org.digitalmodular.wadapi.structure.Sector;
import static org.digitalmodular.wadapi.LumpType.SECTORS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SectorsLump extends ListLump<Sector> {
	public SectorsLump(String name, int initialCapacity) {
		super(name, SECTORS, "sector", initialCapacity);
	}
}
