package org.digitalmodular.wadapi.lump;

import org.digitalmodular.wadapi.LumpType;
import org.digitalmodular.wadapi.structure.Subsector;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SubsectorsLump extends ListLump<Subsector> {
	public SubsectorsLump(String name, int initialCapacity) {
		super(name, LumpType.SSECTORS, "subsector", initialCapacity);
	}
}
