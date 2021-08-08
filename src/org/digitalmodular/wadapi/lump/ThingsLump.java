package wadapi.lump;

import wadapi.structure.Thing;
import static wadapi.LumpType.THINGS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class ThingsLump extends ListLump<Thing> {
	public ThingsLump(String name, int initialCapacity) {
		super(name, THINGS, "thing", initialCapacity);
	}
}
