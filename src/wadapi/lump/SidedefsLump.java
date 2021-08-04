package wadapi.lump;

import java.util.ArrayList;
import java.util.List;

import wadapi.LumpType;
import wadapi.structure.Sidedef;
import static wadapi.LumpType.SIDEDEFS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SidedefsLump extends Lump {
	private final List<Sidedef> sidedefs;

	public SidedefsLump(String name, int initialCapacity) {
		super(name);

		sidedefs = new ArrayList<>(initialCapacity);
	}

	public List<Sidedef> getSidedefs() {
		return sidedefs;
	}

	@Override
	public LumpType getLumpType() {
		return SIDEDEFS;
	}
}
