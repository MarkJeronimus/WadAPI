package wadapi.lump;

import java.util.ArrayList;
import java.util.List;

import wadapi.LumpType;
import wadapi.structure.Subsector;
import static wadapi.LumpType.SSECTORS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SubsectorsLump extends Lump {
	private final List<Subsector> subsectors;

	public SubsectorsLump(String name, int initialCapacity) {
		super(name);

		subsectors = new ArrayList<>(initialCapacity);
	}

	public List<Subsector> getSubsectors() {
		return subsectors;
	}

	@Override
	public LumpType getLumpType() {
		return SSECTORS;
	}
}
