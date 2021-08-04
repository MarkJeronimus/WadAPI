package wadapi.lump;

import java.util.ArrayList;
import java.util.List;

import wadapi.LumpType;
import wadapi.structure.Sector;
import static wadapi.LumpType.SECTORS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SectorsLump extends Lump {
	private final List<Sector> sectors;

	public SectorsLump(String name, int initialCapacity) {
		super(name);

		sectors = new ArrayList<>(initialCapacity);
	}

	public List<Sector> getSectors() {
		return sectors;
	}

	@Override
	public LumpType getLumpType() {
		return SECTORS;
	}
}
