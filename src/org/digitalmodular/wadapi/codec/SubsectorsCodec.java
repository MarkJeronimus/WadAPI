package org.digitalmodular.wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.LumpUtilities;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.SubsectorsLump;
import org.digitalmodular.wadapi.structure.Subsector;

/**
 * Generated by node builders
 *
 * @author Zom-B
 */
// Created 2011-08-15
@Singleton
public class SubsectorsCodec extends LumpCodec<SubsectorsLump> {
	public static final int SUBSECTOR_FIELD_SIZE = 4;

	public static final SubsectorsCodec INSTANCE = new SubsectorsCodec();

	@Override
	public SubsectorsLump decode(FileBufferLump lump) {
		String     name       = lump.getName();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numSubsectors = LumpUtilities.calcNumFields(fileBuffer.remaining(), SUBSECTOR_FIELD_SIZE, name);

		SubsectorsLump subsectorsLump = new SubsectorsLump(name, numSubsectors);

		for (int i = 0; i < numSubsectors; i++) {
			Subsector subsector = readSubsector(fileBuffer);
			subsectorsLump.add(subsector);
		}

		return subsectorsLump;
	}

	@Override
	public void encode(SubsectorsLump subsectorsLump, FileBuffer buffer) {
		throw new UnsupportedOperationException("Not implemented: " + SubsectorsCodec.class.getSimpleName() +
		                                        ".encode()");
	}

	private static Subsector readSubsector(FileBuffer buffer) {
		int numSegs  = buffer.getUnsignedShort();
		int firstSeg = buffer.getUnsignedShort();

		return new Subsector(numSegs, firstSeg);
	}
}
