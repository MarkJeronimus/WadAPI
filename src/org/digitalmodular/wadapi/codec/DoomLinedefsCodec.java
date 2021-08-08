package org.digitalmodular.wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.LumpUtilities;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.LinedefsLump;
import org.digitalmodular.wadapi.structure.DoomLinedef;
import org.digitalmodular.wadapi.structure.Linedef;

/**
 * @author Zom-B
 */
// Created 2011-08-14
@Singleton
public class DoomLinedefsCodec extends LumpCodec<LinedefsLump> {
	public static final int LINEDEF_FIELD_SIZE = 14;

	public static final DoomLinedefsCodec INSTANCE = new DoomLinedefsCodec();

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
			if (!(linedef instanceof DoomLinedef))
				throw new IllegalArgumentException("Not all linedefs are " + DoomLinedef.class.getSimpleName() + ": " +
				                                   linedef.getClass());

			writeLinedef((DoomLinedef)linedef, buffer);
		}
	}

	private static DoomLinedef readLinedef(FileBuffer buffer) {
		int vertexFrom     = buffer.getUnsignedShort();
		int vertexTo       = buffer.getUnsignedShort();
		int flags          = buffer.getUnsignedShort();
		int special        = buffer.getUnsignedShort();
		int tag            = buffer.getUnsignedShort();
		int frontSidedefID = buffer.getUnsignedShort();
		int backSidedefID  = buffer.getUnsignedShort();

		return new DoomLinedef(vertexFrom,
		                       vertexTo,
		                       flags,
		                       special,
		                       tag,
		                       frontSidedefID == 65535 ? Linedef.NO_SIDEDEF : frontSidedefID,
		                       backSidedefID == 65535 ? Linedef.NO_SIDEDEF : backSidedefID);
	}

	private static void writeLinedef(DoomLinedef linedef, FileBuffer buffer) {
		buffer.putUnsignedShort(linedef.getVertexFrom());
		buffer.putUnsignedShort(linedef.getVertexTo());
		buffer.putUnsignedShort(linedef.getFlags());
		buffer.putUnsignedShort(linedef.getSpecial());
		buffer.putUnsignedShort(linedef.getTag());
		int frontSidedef = linedef.getFrontSidedef();
		int backSidedef  = linedef.getBackSidedef();
		buffer.putUnsignedShort(frontSidedef == Linedef.NO_SIDEDEF ? 65535 : frontSidedef);
		buffer.putUnsignedShort(backSidedef == Linedef.NO_SIDEDEF ? 65535 : backSidedef);
	}
}
