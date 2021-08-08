package org.digitalmodular.wadapi.lump;

import org.digitalmodular.wadapi.structure.Linedef;
import static org.digitalmodular.wadapi.LumpType.LINEDEFS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class LinedefsLump extends ListLump<Linedef> {
	public LinedefsLump(String name, int initialCapacity) {
		super(name, LINEDEFS, "linedef", initialCapacity);
	}
}
