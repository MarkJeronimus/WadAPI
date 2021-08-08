package wadapi.lump;

import wadapi.structure.Sector;
import static wadapi.LumpType.SECTORS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SectorsLump extends ListLump<Sector> {
	public SectorsLump(String name, int initialCapacity) {
		super(name, SECTORS, "sector", initialCapacity);
	}
}
