package wadapi.codec;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.FileBuffer;
import wadapi.MapFormat;
import wadapi.WadFile;
import wadapi.WadStorage;
import wadapi.lump.FileBufferLump;
import wadapi.lump.Lump;

/**
 * @param <E> Type of {@code WadLump} this codec handles
 * @author Zom-B
 */
// Created 2018-01-20
public abstract class LumpCodec<E extends Lump> {
	private final Class<E> lumpClass;

	@Deprecated
	private MapFormat wadFormat = MapFormat.DOOM;

	protected LumpCodec(Class<E> lumpClass) {
		this.lumpClass = lumpClass;
	}

	@Deprecated
	public MapFormat getWadFormat() {
		return wadFormat;
	}

	@Deprecated
	public void setWadFormat(MapFormat wadFormat) {
		this.wadFormat = requireNonNull(wadFormat, "wadFormat");
	}

	public E decode(WadStorage storage, int wadIndex, int lumpIndex) {
		WadFile wadFile = storage.getWad(wadIndex);
		Lump    lump    = wadFile.get(lumpIndex);

		if (lump instanceof FileBufferLump)
			return decode((FileBufferLump)lump);

		if (lumpClass.isInstance(lump))
			//noinspection unchecked
			return (E)lump;

		throw new IllegalArgumentException("Specified lump is not of type " + lumpClass +
		                                   " (wadIndex=" + wadIndex + ", lumpIndex=" + lumpIndex + ')');
	}

	public abstract E decode(FileBufferLump lump);

	public abstract void encode(E e, FileBuffer buffer);

}
