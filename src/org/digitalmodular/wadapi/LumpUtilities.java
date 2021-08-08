package org.digitalmodular.wadapi;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import org.digitalmodular.utilities.annotation.UtilityClass;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import org.digitalmodular.wadapi.codec.BinaryCodec;
import org.digitalmodular.wadapi.codec.FlatCodec;
import org.digitalmodular.wadapi.codec.LumpCodec;
import org.digitalmodular.wadapi.codec.MarkerCodec;
import org.digitalmodular.wadapi.codec.PaletteCodec;
import org.digitalmodular.wadapi.codec.PatchCodec;
import org.digitalmodular.wadapi.codec.PatchNamesCodec;
import org.digitalmodular.wadapi.codec.SpriteCodec;
import org.digitalmodular.wadapi.codec.TextCodec;
import org.digitalmodular.wadapi.codec.TextureXCodec;
import org.digitalmodular.wadapi.io.LumpPointer;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.Lump;

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
