package wadapi;

import net.jcip.annotations.NotThreadSafe;

import org.digitalmodular.utilities.annotation.UtilityClass;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.codec.LumpCodec;
import wadapi.codec.LumpCodecs;
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

		LumpType   lumpType   = lump.getLumpType();
		FileBuffer fileBuffer = ((FileBufferLump)lump).getFileBuffer();

		int remaining = fileBuffer.remaining();

		LumpCodec<? extends Lump> codec = LumpCodecs.getCodec(lumpType, remaining);

		Lump decodedLump = codec.decode((FileBufferLump)lump);
		return decodedLump;
	}
}
