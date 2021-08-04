package wadapi.codec;

import wadapi.FileBuffer;
import wadapi.lump.FileBufferLump;
import wadapi.lump.MarkerLump;

/**
 * @author Zom-B
 */
// Created 2011-09-12
public final class MarkerCodec extends LumpCodec<MarkerLump> {
	public static final MarkerCodec INSTANCE = new MarkerCodec();

	public MarkerCodec() {
		super(MarkerLump.class);
	}

	@Override
	public MarkerLump decode(FileBufferLump lump) {
		return new MarkerLump(lump.getName(), lump.getLumpType());
	}

	@Override
	public void encode(MarkerLump blob, FileBuffer buffer) {
	}
}
