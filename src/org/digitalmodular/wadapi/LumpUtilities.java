package wadapi;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import org.digitalmodular.utilities.annotation.UtilityClass;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.codec.BinaryCodec;
import wadapi.codec.FlatCodec;
import wadapi.codec.LumpCodec;
import wadapi.codec.MarkerCodec;
import wadapi.codec.PaletteCodec;
import wadapi.codec.PatchCodec;
import wadapi.codec.PatchNamesCodec;
import wadapi.codec.SpriteCodec;
import wadapi.codec.TextCodec;
import wadapi.codec.TextureXCodec;
import wadapi.io.LumpPointer;
import wadapi.lump.FileBufferLump;
import wadapi.lump.Lump;

/**
 * @author Zom-B
 */
// Created 2018-01-21
@UtilityClass
public final class LumpUtilities {
	private LumpUtilities() {
		throw new AssertionError();
	}

	/**
	 * Decodes the proto lump pointed to by the pointer, and if successful,
	 * overwrites the proto lump in storage with the decoded lump.
	 */
	@Contract("null -> null; !null -> !null")
	public static @Nullable Lump decodeLump(@Nullable LumpPointer lumpPointer) {
		if (lumpPointer == null)
			return null;

		Lump lump        = lumpPointer.getLump();
		Lump decodedLump = decodeLump(lump);

		//noinspection ObjectEquality // Comparing identity, not equality
		if (decodedLump != lump)
			lumpPointer.setLump(decodedLump);

		return decodedLump;
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
			case UNASSIGNED:
				return BinaryCodec.INSTANCE;
			case MAP:
			case MARKER:
				return size > 0 ? BinaryCodec.INSTANCE : MarkerCodec.INSTANCE;
			case FLAT:
				return FlatCodec.INSTANCE;
			case PATCH:
				return PatchCodec.INSTANCE;
			case SPRITE:
				return SpriteCodec.INSTANCE;
			case FONT:
			case COLORMAPS:
			case ACSLIBRARY:
			case NEWTEXTURES:
			case STRIFEVOICES:
			case HIRES:
			case VOXELS:
				throw new UnsupportedOperationException("No decoder for " + type + " yet.");
			case THINGS:
			case LINEDEFS:
			case SIDEDEFS:
			case VERTEXES:
			case SEGS:
			case SSECTORS:
			case NODES:
			case SECTORS:
			case REJECT:
			case BLOCKMAP:
			case SCRIPTS:
			case BEHAVIOR:
				throw new IllegalArgumentException("Lumps of type " + type + " need to be decoded as part of a map");
			case PLAYPAL:
				return PaletteCodec.INSTANCE;
			case PNAMES:
				return PatchNamesCodec.INSTANCE;
			case TEXTUREX:
				return TextureXCodec.INSTANCE;
			case TEXT:
				return TextCodec.INSTANCE;
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
