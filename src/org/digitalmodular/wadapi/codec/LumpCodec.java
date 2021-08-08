package org.digitalmodular.wadapi.codec;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.MapFormat;
import org.digitalmodular.wadapi.io.LumpPointer;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.Lump;

/**
 * @param <E> Type of {@code WadLump} this codec handles
 * @author Zom-B
 */
// Created 2018-01-20
public abstract class LumpCodec<E extends Lump> {
	@Deprecated
	private MapFormat wadFormat = MapFormat.DOOM;

	@Deprecated
	public MapFormat getWadFormat() {
		return wadFormat;
	}

	@Deprecated
	public void setWadFormat(MapFormat wadFormat) {
		this.wadFormat = requireNonNull(wadFormat, "wadFormat");
	}

	@Contract("null -> null; !null -> !null")
	public @Nullable Lump decode(@Nullable LumpPointer lumpPointer) {
		if (lumpPointer == null)
			return null;

		Lump lump = lumpPointer.getLump();
		if (!(lump instanceof FileBufferLump))
			return lump;

		return decode((FileBufferLump)lump);

	}

	public abstract E decode(FileBufferLump lump);

	public abstract void encode(E e, FileBuffer buffer);
}
