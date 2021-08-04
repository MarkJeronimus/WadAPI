package wadapi.lump;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.LumpType;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class MarkerLump extends Lump {
	private final LumpType lumpType;

	public MarkerLump(String name, LumpType lumpType) {
		super(name);

		this.lumpType = requireNonNull(lumpType, "lumpType");
	}

	@Override
	public LumpType getLumpType() {
		return lumpType;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + '[' + getName() + ", " + lumpType + ']';
	}
}
