package wadapi.lump;

import java.util.ArrayList;
import java.util.List;

import wadapi.LumpType;
import wadapi.structure.Palette;
import static wadapi.LumpType.PLAYPAL;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class PaletteLump extends Lump {
	private final List<Palette> palettes;

	public PaletteLump(String name, int initialCapacity) {
		super(name);

		palettes = new ArrayList<>(initialCapacity);
	}

	public List<Palette> getPalettes() {
		return palettes;
	}

	@Override
	public LumpType getLumpType() {
		return PLAYPAL;
	}
}
