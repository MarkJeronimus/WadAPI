package wadapi.lump;

import java.util.ArrayList;
import java.util.List;

import wadapi.LumpType;
import wadapi.structure.SubSector;
import static wadapi.LumpType.SSECTORS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SubsectorsLump extends Lump {
	private final List<SubSector> subSectors;

	public SubsectorsLump(String name, int initialCapacity) {
		super(name);

		subSectors = new ArrayList<>(initialCapacity);
	}

	public List<SubSector> getSubSectors() {
		return subSectors;
	}

	@Override
	public LumpType getLumpType() {
		return SSECTORS;
	}
}
