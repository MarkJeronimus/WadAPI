package wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import wadapi.FileBuffer;
import wadapi.lump.FileBufferLump;
import wadapi.structure.FlatLump;

/**
 * @author Zom-B
 */
// Created 2011-09-12
@Singleton
public class FlatCodec extends LumpCodec<FlatLump> {
	public static final FlatCodec INSTANCE = new FlatCodec();

	public FlatCodec() {
		super(FlatLump.class);
	}

	@Override
	public FlatLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer = lump.getFileBuffer();

		byte[] data = new byte[fileBuffer.remaining()];
		fileBuffer.getArray(data);

		return new FlatLump(lump.getName(), data);
	}

	@Override
	public void encode(FlatLump floor, FileBuffer buffer) {
		buffer.putArray(floor.getData());
	}
}
