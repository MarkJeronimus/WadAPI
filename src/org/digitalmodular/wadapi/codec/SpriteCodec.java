package org.digitalmodular.wadapi.codec;

import java.util.ArrayList;
import java.util.List;

import org.digitalmodular.utilities.annotation.Singleton;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.SpriteLump;
import org.digitalmodular.wadapi.structure.SpritePost;

/**
 * @author Zom-B
 */
// Created 2011-09-12
@Singleton
public class SpriteCodec extends LumpCodec<SpriteLump> {
	public static final SpriteCodec INSTANCE = new SpriteCodec();

	@Override
	public SpriteLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer  = lump.getFileBuffer();
		int        bufferStart = fileBuffer.position();

		int   width         = fileBuffer.getUnsignedShort();
		int   height        = fileBuffer.getUnsignedShort();
		int   leftOffset    = fileBuffer.getShort();
		int   topOffset     = fileBuffer.getShort();
		int[] columnOffsets = new int[width];

		for (int i = 0; i < width; i++)
			columnOffsets[i] = fileBuffer.getInt();

		List<List<SpritePost>> columns = new ArrayList<>(width);
		for (int i = 0; i < width; i++) {
			List<SpritePost> column = new ArrayList<>(4);

			fileBuffer.position(bufferStart + columnOffsets[i]);

			while (true) {
				int topDelta = fileBuffer.getUnsignedByte();
				if (topDelta == 0xFF)
					break;

				int length = fileBuffer.getUnsignedByte();
				fileBuffer.position(fileBuffer.position() + 1); // Unused padding byte

				byte[] data = new byte[length];
				fileBuffer.getArray(data);

				fileBuffer.position(fileBuffer.position() + 1); // Unused padding byte

				column.add(new SpritePost(topDelta, data));
			}

			columns.add(column);
		}

		return new SpriteLump(lump.getName(), height, leftOffset, topOffset, columns);
	}

	@Override
	public void encode(SpriteLump sprite, FileBuffer buffer) {
		throw new UnsupportedOperationException("Not implemented: " + SpriteCodec.class.getSimpleName() +
		                                        ".encode()");
	}
}
