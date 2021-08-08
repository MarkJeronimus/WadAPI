package org.digitalmodular.wadapi.codec;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.MarkerLump;

/**
 * @author Zom-B
 */
// Created 2011-09-12
public final class MarkerCodec extends LumpCodec<MarkerLump> {
	public static final MarkerCodec INSTANCE = new MarkerCodec();

	@Override
	public MarkerLump decode(FileBufferLump lump) {
		return new MarkerLump(lump.getName(), lump.getLumpType());
	}

	@Override
	public void encode(MarkerLump blob, FileBuffer buffer) {
	}
}
