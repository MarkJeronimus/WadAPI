package wadapi.structure;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.lump.Lump;
import static wadapi.LumpType.FLAT;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class FlatLump extends Lump {
	private final byte[] data;

	public FlatLump(String name) {
		super(name, FLAT);

		data = new byte[65536];
	}

	public FlatLump(String name, byte[] data) {
		super(name, FLAT);

		this.data = requireNonNull(data, "data");
	}

	public byte[] getData() {
		return data;
	}
}
