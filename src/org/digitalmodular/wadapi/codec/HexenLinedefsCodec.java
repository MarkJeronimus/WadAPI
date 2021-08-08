package org.digitalmodular.wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.LumpUtilities;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.LinedefsLump;
import org.digitalmodular.wadapi.structure.HexenLinedef;
import org.digitalmodular.wadapi.structure.Linedef;

/**
 * @author Zom-B
 */
// Created 2021-08-08
@Singleton
public class HexenLinedefsCodec extends LumpCodec<LinedefsLump> {
	public static final int LINEDEF_FIELD_SIZE = 16;

	public static final HexenLinedefsCodec INSTANCE = new HexenLinedefsCodec();

	@Override
	public LinedefsLump decode(FileBufferLump lump) {
		String     name       = lump.getName();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numLinedefs = LumpUtilities.calcNumFields(fileBuffer.remaining(), LINEDEF_FIELD_SIZE, name);

		LinedefsLump linedefsLump = new LinedefsLump(name, numLinedefs);

		for (int i = 0; i < numLinedefs; i++)
			linedefsLump.add(readLinedef(fileBuffer));

		return linedefsLump;
	}

	@Override
	public void encode(LinedefsLump linedefsLump, FileBuffer buffer) {
		for (Linedef linedef : linedefsLump) {
			if (!(linedef instanceof HexenLinedef))
				throw new IllegalArgumentException("Not all linedefs are " + HexenLinedef.class.getSimpleName() + ": " +
				                                   linedef.getClass());

			writeLinedef((HexenLinedef)linedef, buffer);
		}
	}

	private static HexenLinedef readLinedef(FileBuffer buffer) {
		int vertexFrom     = buffer.getUnsignedShort();
		int vertexTo       = buffer.getUnsignedShort();
		int flags          = buffer.getUnsignedShort();
		int action         = buffer.getUnsignedByte();
		int ar1            = buffer.getUnsignedByte();
		int ar2            = buffer.getUnsignedByte();
		int ar3            = buffer.getUnsignedByte();
		int ar4            = buffer.getUnsignedByte();
		int ar5            = buffer.getUnsignedByte();
		int frontSidedefID = buffer.getUnsignedShort();
		int backSidedefID  = buffer.getUnsignedShort();

		return new HexenLinedef(vertexFrom,
		                        vertexTo,
		                        flags,
		                        action,
		                        ar1,
		                        ar2,
		                        ar3,
		                        ar4,
		                        ar5,
		                        frontSidedefID == 65535 ? Linedef.NO_SIDEDEF : frontSidedefID,
		                        backSidedefID == 65535 ? Linedef.NO_SIDEDEF : backSidedefID);
	}

	private static void writeLinedef(HexenLinedef linedef, FileBuffer buffer) {
		throw new UnsupportedOperationException("Not implemented: " + HexenLinedefsCodec.class.getSimpleName() +
		                                        ".writeHexenLinedef()");
	}
}
