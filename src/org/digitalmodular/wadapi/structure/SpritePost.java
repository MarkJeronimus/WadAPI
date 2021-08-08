package org.digitalmodular.wadapi.structure;

import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

/**
 * @author Zom-B
 */
// Created 2021-06-08
public class SpritePost {
	private int    topDelta;
	private byte[] data;

	public SpritePost(int topDelta, byte[] data) {
		this.topDelta = requireAtLeast(0, topDelta, "topDelta");
		this.data = requireNonNull(data, "data");
	}

	public int getTopDelta() {
		return topDelta;
	}

	public void setTopDelta(int topDelta) {
		this.topDelta = requireAtLeast(0, topDelta, "topDelta");
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = requireNonNull(data, "data");
	}
}
