package wadapi.lump;

import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.LumpType;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class TextLump extends Lump {
	private final LumpType      lumpType;
	private final StringBuilder text;

	public TextLump(String name, LumpType lumpType, int initialCapacity) {
		super(name);

		this.lumpType = requireNonNull(lumpType, "lumpType");
		text = new StringBuilder(requireAtLeast(1, initialCapacity, "initialCapacity"));
	}

	public StringBuilder getText() {
		return text;
	}

	@Override
	public LumpType getLumpType() {
		return lumpType;
	}
}
