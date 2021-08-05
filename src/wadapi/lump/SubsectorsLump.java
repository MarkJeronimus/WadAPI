package wadapi.lump;

import wadapi.structure.Subsector;
import static wadapi.LumpType.SSECTORS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SubsectorsLump extends ListLump<Subsector> {
	public SubsectorsLump(String name, int initialCapacity) {
		super(name, SSECTORS, "subsector", initialCapacity);
	}
}
