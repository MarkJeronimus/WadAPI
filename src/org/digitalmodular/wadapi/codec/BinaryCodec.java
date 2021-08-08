package org.digitalmodular.wadapi.codec;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.lump.BinaryLump;
import org.digitalmodular.wadapi.lump.FileBufferLump;

/**
 * @author Zom-B
 */
// Created 2011-09-12
public final class BinaryCodec extends LumpCodec<BinaryLump> {
	public static final BinaryCodec INSTANCE = new BinaryCodec();

	@Override
	public BinaryLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer = lump.getFileBuffer();

		byte[] blob = new byte[fileBuffer.remaining()];
		fileBuffer.getArray(blob);

		return new BinaryLump(lump.getName(), lump.getLumpType(), blob);
	}

	@Override
	public void encode(BinaryLump blob, FileBuffer buffer) {
		buffer.putArray(blob.getData());
	}
}
