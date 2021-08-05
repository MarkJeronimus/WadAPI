package wadapi.codec;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.FileBuffer;
import wadapi.MapFormat;
import wadapi.io.LumpPointer;
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

	public E decode(LumpPointer pointer) {
		Lump lump = pointer.getLump();

		if (lumpClass.isInstance(lump))
			//noinspection unchecked
			return (E)lump;

		if (lump instanceof FileBufferLump)
			return decode((FileBufferLump)lump);

		throw new IllegalArgumentException("Specified lump is not of type FileBufferLump or " + lumpClass +
		                                   " (" + pointer + ')');
	}

	public abstract E decode(FileBufferLump lump);

	public abstract void encode(E e, FileBuffer buffer);

}
