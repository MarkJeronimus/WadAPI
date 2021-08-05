package wadapi.lump;

import wadapi.structure.Sidedef;
import static wadapi.LumpType.SIDEDEFS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SidedefsLump extends ListLump<Sidedef> {
	public SidedefsLump(String name, int initialCapacity) {
		super(name, SIDEDEFS, "sidedef", initialCapacity);
	}
}
