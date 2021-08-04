package wadapi.lump;

import java.util.ArrayList;
import java.util.List;

import wadapi.LumpType;
import wadapi.structure.Thing;
import static wadapi.LumpType.THINGS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class ThingsLump extends Lump {
	private final List<Thing> things;

	public ThingsLump(String name, int initialCapacity) {
		super(name);

		things = new ArrayList<>(initialCapacity);
	}

	public List<Thing> getThings() {
		return things;
	}

	@Override
	public LumpType getLumpType() {
		return THINGS;
	}
}
