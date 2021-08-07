package wadapi;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.jcip.annotations.NotThreadSafe;

import org.digitalmodular.utilities.annotation.UtilityClass;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.codec.BinaryCodec;
import wadapi.codec.FlatCodec;
import wadapi.codec.LinedefsCodec;
import wadapi.codec.LumpCodec;
import wadapi.codec.MarkerCodec;
import wadapi.codec.PaletteCodec;
import wadapi.codec.PatchCodec;
import wadapi.codec.PatchNamesCodec;
import wadapi.codec.SectorsCodec;
import wadapi.codec.SegmentsCodec;
import wadapi.codec.SidedefsCodec;
import wadapi.codec.SpriteCodec;
import wadapi.codec.SubsectorsCodec;
import wadapi.codec.TextCodec;
import wadapi.codec.TextureXCodec;
import wadapi.codec.ThingsCodec;
import wadapi.codec.VerticesCodec;
import wadapi.lump.FileBufferLump;
import wadapi.lump.Lump;

/**
 * @author Zom-B
 */
// Created 2018-01-21
@NotThreadSafe
@UtilityClass
public final class LumpUtilities {
	private LumpUtilities() {
		throw new AssertionError();
	}

	public static Lump decodeLump(Lump lump) {
		requireNonNull(lump, "lump");

		if (!(lump instanceof FileBufferLump))
			return lump;

		FileBufferLump rawLump = (FileBufferLump)lump;

		LumpCodec<? extends Lump> codec = getCodec(rawLump);

		Lump decodedLump = codec.decode(rawLump);
		return decodedLump;
	}

	public static LumpCodec<? extends Lump> getCodec(FileBufferLump lump) {
		requireNonNull(lump, "lump");

		LumpType   lumpType   = lump.getLumpType();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int remaining = fileBuffer.remaining();

		return getCodec(lumpType, remaining);
	}

	public static LumpCodec<? extends Lump> getCodec(LumpType type, int size) {
		requireNonNull(type, "type");

		switch (type) {
			case BEHAVIOR:
			case UNASSIGNED:
			case BLOCKMAP:
			case REJECT:
				return BinaryCodec.INSTANCE;
			case SPRITE:
				return SpriteCodec.INSTANCE;
			case FLAT:
				return FlatCodec.INSTANCE;
			case LINEDEFS:
				return LinedefsCodec.INSTANCE;
			case MAP:
			case MARKER:
				return size > 0 ? BinaryCodec.INSTANCE : MarkerCodec.INSTANCE;
			case PLAYPAL:
				return PaletteCodec.INSTANCE;
			case PATCH:
				return PatchCodec.INSTANCE;
			case PNAMES:
				return PatchNamesCodec.INSTANCE;
			case SECTORS:
				return SectorsCodec.INSTANCE;
			case SEGS:
				return SegmentsCodec.INSTANCE;
			case SIDEDEFS:
				return SidedefsCodec.INSTANCE;
			case SSECTORS:
				return SubsectorsCodec.INSTANCE;
			case SCRIPTS:
			case TEXT:
				return TextCodec.INSTANCE;
			case TEXTUREX:
				return TextureXCodec.INSTANCE;
			case THINGS:
				return ThingsCodec.INSTANCE;
			case VERTEXES:
				return VerticesCodec.INSTANCE;
			default:
				throw new AssertionError("Unknown LumpType: " + type);
		}
	}

	public static int calcNumFields(int size, int fieldSize, String name) {
		int numFields = size / fieldSize;

		int extra = size - numFields * fieldSize;
		if (extra != 0)
			Logger.getGlobal().log(Level.WARNING, extra + " extra bytes after data: name = " + name +
			                                      ", size = " + size + ", fieldSize = " + fieldSize);

		return numFields;
	}
}
