package org.digitalmodular.wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.LumpUtilities;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.SegmentsLump;
import org.digitalmodular.wadapi.structure.Segment;

/**
 * @author Zom-B
 */
// Created 2021-08-07
@Singleton
public class DeepSegmentsCodec extends LumpCodec<SegmentsLump> {
	public static final int SEGMENT_FIELD_SIZE = 16;

	public static final DeepSegmentsCodec INSTANCE = new DeepSegmentsCodec();

	@Override
	public SegmentsLump decode(FileBufferLump lump) {
		String     name       = lump.getName();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numSegments = LumpUtilities.calcNumFields(fileBuffer.remaining(), SEGMENT_FIELD_SIZE, name);

		SegmentsLump segmentsLump = new SegmentsLump(name, numSegments);

		for (int i = 0; i < numSegments; i++) {
			Segment segment = readSegment(fileBuffer);
			segmentsLump.add(segment);
		}

		return segmentsLump;
	}

	@Override
	public void encode(SegmentsLump segmentsLump, FileBuffer buffer) {
		throw new UnsupportedOperationException("Not implemented: " + DeepSegmentsCodec.class.getSimpleName() +
		                                        ".encode()");
	}

	private static Segment readSegment(FileBuffer buffer) {
		int v1 = buffer.getInt();
		int v2 = buffer.getInt();
		buffer.getShort(); // Unused angle
		int linedef  = buffer.getUnsignedShort();
		int backSide = buffer.getShort();
		buffer.getShort(); // Unused offset

		return new Segment(v1, v2, linedef, backSide != 0);
	}
}
