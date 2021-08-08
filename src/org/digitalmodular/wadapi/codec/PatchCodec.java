package org.digitalmodular.wadapi.codec;

import java.util.Arrays;

import org.digitalmodular.utilities.annotation.Singleton;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.PatchLump;

/**
 * @author Zom-B
 */
// Created 2011-09-12
@Singleton
public class PatchCodec extends LumpCodec<PatchLump> {
	public static final PatchCodec INSTANCE = new PatchCodec();

	@Override
	public PatchLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer = lump.getFileBuffer();

		int   width   = fileBuffer.getUnsignedShort();
		int   height  = fileBuffer.getUnsignedShort();
		short xOffset = fileBuffer.getShort();
		short yOffset = fileBuffer.getShort();

		int[] pixels = new int[height * width];
		Arrays.fill(pixels, -1);

		int[] directory = new int[width];
		for (int i = 0; i < width; i++)
			directory[i] = fileBuffer.getInt();

		for (int x = 0; x < width; x++) {
			fileBuffer.position(directory[x]);

			while (true) {
				int rowStart = fileBuffer.getUnsignedByte();
				if (rowStart == 255)
					break;

				int rowEnd = rowStart + fileBuffer.getUnsignedByte();

				fileBuffer.skip(1); // Dummy byte

				for (int y = rowStart; y < rowEnd; y++)
					pixels[y * width + x] = fileBuffer.getUnsignedByte();

				fileBuffer.skip(1); // Dummy byte
			}
		}

		return new PatchLump(lump.getName(), width, height, xOffset, yOffset, pixels);
	}

	@Override
	public void encode(PatchLump patch, FileBuffer buffer) {
		int   width  = patch.getWidth();
		int   height = patch.getHeight();
		int[] pixels = patch.getPixels();

		buffer.putUnsignedShort(width);
		buffer.putUnsignedShort(height);
		buffer.putShort(patch.getXOffset());
		buffer.putShort(patch.getYOffset());

		// Seek to the first byte after the directory (where the image data will
		// begin)
		buffer.position(width * 4 + 8);

		for (int x = 0; x < width; x++) {
			{
				// Write a new directory entry without changing the pointer in
				// the image data.
				int offset = buffer.position();
				buffer.position(x * 4 + 8);
				buffer.putInt(offset);
				buffer.position(offset);
			}

			int rowStart = -1;

			int pixelCountPtr = 0;
			for (int y = 0; y < height; y++) {
				int c = pixels[y * width + x];

				if (rowStart == -1 && c != -1) {
					rowStart = y;
					buffer.putUnsignedByte(rowStart); // Write row start

					pixelCountPtr = buffer.position();
					buffer.skip(1); // 'encode' row length

					buffer.putUnsignedByte(0); // Write dummy value
				}

				if (rowStart != -1) {
					if (c != -1) {

						buffer.putUnsignedByte(c); // Write pixel value
					} else {
						buffer.putUnsignedByte(0); // Write dummy value

						// Write calculated column height without changing
						// the pointer in the image data.
						int offset = buffer.position();
						buffer.position(pixelCountPtr);
						buffer.putUnsignedByte(y - rowStart);
						buffer.position(offset);

						rowStart = -1;
					}
				}
			}

			if (rowStart != -1) {
				buffer.putUnsignedByte(0); // Write dummy value

				// Write calculated column height without changing the
				// pointer in the image data.
				int offset = buffer.position();
				buffer.position(pixelCountPtr);
				buffer.putUnsignedByte(height - rowStart);
				buffer.position(offset);
			}

			buffer.putUnsignedByte(255); // Write end-of-column marker
		}
	}
}
