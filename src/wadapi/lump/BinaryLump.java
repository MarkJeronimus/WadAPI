package wadapi.lump;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.LumpType;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class BinaryLump extends Lump {
	private final LumpType lumpType;
	private final byte[]   data;

	public BinaryLump(String name, LumpType lumpType, byte[] data) {
		super(name);

		this.lumpType = requireNonNull(lumpType, "lumpType");
		this.data = requireNonNull(data, "data");
	}

	public byte[] getData() {
		return data;
	}

	@Override
	public LumpType getLumpType() {
		return lumpType;
	}
}
