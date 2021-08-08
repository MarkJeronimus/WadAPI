package org.digitalmodular.wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.structure.FlatLump;

/**
 * @author Zom-B
 */
// Created 2011-09-12
@Singleton
public class FlatCodec extends LumpCodec<FlatLump> {
	public static final FlatCodec INSTANCE = new FlatCodec();

	@Override
	public FlatLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer = lump.getFileBuffer();

		byte[] data = new byte[fileBuffer.remaining()];
		fileBuffer.getArray(data);

		return new FlatLump(lump.getName(), data);
	}

	@Override
	public void encode(FlatLump floor, FileBuffer buffer) {
		buffer.putArray(floor.getData());
	}
}
