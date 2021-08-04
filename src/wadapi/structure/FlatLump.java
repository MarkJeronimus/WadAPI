package wadapi.structure;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.LumpType;
import wadapi.lump.Lump;
import static wadapi.LumpType.FLAT;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class FlatLump extends Lump {
	private final byte[] data;

	public FlatLump(String name) {
		super(name);

		data = new byte[65536];
	}

	public FlatLump(String name, byte[] data) {
		super(name);

		this.data = requireNonNull(data, "data");
	}

	public byte[] getData() {
		return data;
	}

	@Override
	public LumpType getLumpType() {
		return FLAT;
	}
}
