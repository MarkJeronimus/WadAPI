package org.digitalmodular.wadapi.lump;

import org.digitalmodular.wadapi.LumpType;
import org.digitalmodular.wadapi.structure.Thing;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class ThingsLump extends ListLump<Thing> {
	public ThingsLump(String name, int initialCapacity) {
		super(name, LumpType.THINGS, "thing", initialCapacity);
	}
}
