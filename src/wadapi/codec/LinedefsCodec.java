package wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import wadapi.FileBuffer;
import wadapi.LumpUtilities;
import wadapi.MapFormat;
import wadapi.lump.FileBufferLump;
import wadapi.lump.LinedefsLump;
import wadapi.structure.DoomLinedef;
import wadapi.structure.HexenLinedef;
import wadapi.structure.Linedef;
import static wadapi.structure.Linedef.NO_SIDEDEF;

/**
 * @author Zom-B
 */
// Created 2011-08-14
@Singleton
public class LinedefsCodec extends LumpCodec<LinedefsLump> {
	public static final int LINEDEF_FIELD_SIZE_DOOM  = 14;
	public static final int LINEDEF_FIELD_SIZE_HEXEN = 16;

	public static final LinedefsCodec INSTANCE = new LinedefsCodec();

	public LinedefsCodec() {
		super(LinedefsLump.class);
	}

	@Override
	public LinedefsLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer  = lump.getFileBuffer();
		int        fieldSize   = getFieldSize(getWadFormat());
		int        numLinedefs = LumpUtilities.calcNumFields(fileBuffer.remaining(), fieldSize, lump.getName());

		LinedefsLump linedefsLump = new LinedefsLump(lump.getName(), numLinedefs);

		switch (getWadFormat()) {
			case DOOM:
				for (int i = 0; i < numLinedefs; i++)
					linedefsLump.add(readDoomLinedef(fileBuffer));

				break;
			case HEXEN: // hasBehavior
				for (int i = 0; i < numLinedefs; i++)
					linedefsLump.add(readHexenLinedef(fileBuffer));

				break;
			default:
				throw new AssertionError("Unimplemented: " + getWadFormat());
		}

		return linedefsLump;
	}

	@Override
	public void encode(LinedefsLump linedefsLump, FileBuffer buffer) {
		switch (getWadFormat()) {
			case DOOM:
				for (Linedef linedef : linedefsLump)
					writeDoomLinedef((DoomLinedef)linedef, buffer);

				break;
			case HEXEN:
				for (Linedef linedef : linedefsLump)
					writeHexenLinedef((HexenLinedef)linedef, buffer);

				break;
			default:
				throw new AssertionError("Unimplemented: " + getWadFormat());
		}
	}

	public int getFieldSize(MapFormat wadFormat) {
		switch (getWadFormat()) {
			case DOOM:
				return LINEDEF_FIELD_SIZE_DOOM;
			case HEXEN:
				return LINEDEF_FIELD_SIZE_HEXEN;
			default:
				throw new AssertionError("Unimplemented: " + wadFormat);
		}
	}

	private static DoomLinedef readDoomLinedef(FileBuffer buffer) {
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
		                       frontSidedefID == 65535 ? NO_SIDEDEF : frontSidedefID,
		                       backSidedefID == 65535 ? NO_SIDEDEF : backSidedefID);
	}

	private static void writeDoomLinedef(DoomLinedef linedef, FileBuffer buffer) {
		buffer.putUnsignedShort(linedef.getVertexFrom());
		buffer.putUnsignedShort(linedef.getVertexTo());
		buffer.putUnsignedShort(linedef.getFlags());
		buffer.putUnsignedShort(linedef.getSpecial());
		buffer.putUnsignedShort(linedef.getTag());
		int frontSidedef = linedef.getFrontSidedef();
		int backSidedef  = linedef.getBackSidedef();
		buffer.putUnsignedShort(frontSidedef == NO_SIDEDEF ? 65535 : frontSidedef);
		buffer.putUnsignedShort(backSidedef == NO_SIDEDEF ? 65535 : backSidedef);
	}

	private static HexenLinedef readHexenLinedef(FileBuffer buffer) {
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
		                        frontSidedefID == 65535 ? NO_SIDEDEF : frontSidedefID,
		                        backSidedefID == 65535 ? NO_SIDEDEF : backSidedefID);
	}

	private static void writeHexenLinedef(HexenLinedef linedef, FileBuffer buffer) {
		throw new UnsupportedOperationException("Not implemented: " + LinedefsCodec.class.getSimpleName() +
		                                        ".writeHexenLinedef()");
	}
}
