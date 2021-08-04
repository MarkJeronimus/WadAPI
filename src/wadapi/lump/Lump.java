package wadapi.lump;

import static org.digitalmodular.utilities.ValidatorUtilities.requireStringLengthBetween;

import wadapi.LumpType;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public abstract class Lump {
	private final String name;

	protected Lump(String name) {
		if (!"WadHeader".equals(name) && !"InfoTable".equals(name))
			requireStringLengthBetween(1, 8, name, "name");

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract LumpType getLumpType();

	@Override
	public String toString() {
		return getClass().getSimpleName() + '[' + name + ']';
	}
}
