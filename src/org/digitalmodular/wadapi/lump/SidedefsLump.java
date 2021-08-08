package org.digitalmodular.wadapi.lump;

import org.digitalmodular.wadapi.LumpType;
import org.digitalmodular.wadapi.structure.Sidedef;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SidedefsLump extends ListLump<Sidedef> {
	public SidedefsLump(String name, int initialCapacity) {
		super(name, LumpType.SIDEDEFS, "sidedef", initialCapacity);
	}
}
