package wadapi.codec;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.FileBuffer;
import wadapi.MapFormat;
import wadapi.lump.FileBufferLump;
import wadapi.lump.Lump;

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

	public abstract E decode(FileBufferLump lump);

	public abstract void encode(E e, FileBuffer buffer);
}
