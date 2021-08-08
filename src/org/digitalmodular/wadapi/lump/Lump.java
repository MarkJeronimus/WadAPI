package wadapi.lump;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;
import static org.digitalmodular.utilities.ValidatorUtilities.requireStringLengthBetween;

import wadapi.LumpType;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public abstract class Lump {
	private final String   name;
	private final LumpType lumpType;

	protected Lump(String name, LumpType lumpType) {
		if (!"WadHeader".equals(name) && !"InfoTable".equals(name))
			requireStringLengthBetween(1, 8, name, "name");

		this.name = name;
		this.lumpType = requireNonNull(lumpType, "lumpType");
	}

	public String getName() {
		return name;
	}

	public final LumpType getLumpType() {
		return lumpType;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + '[' + getName() + ", " + getLumpType() + ']';
	}
}
