package wadapi.lump;

import java.util.ArrayList;
import java.util.List;

import wadapi.LumpType;
import static wadapi.LumpType.PNAMES;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class PatchNamesLump extends Lump {
	private final List<String> patchNames;

	public PatchNamesLump(String name, int initialCapacity) {
		super(name);

		patchNames = new ArrayList<>(initialCapacity);
	}

	public List<String> getPatchNames() {
		return patchNames;
	}

	@Override
	public LumpType getLumpType() {
		return PNAMES;
	}
}
