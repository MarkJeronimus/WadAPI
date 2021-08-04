package wadapi.io;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import org.digitalmodular.utilities.annotation.StaticClass;

import wadapi.FileBuffer;

/**
 * @author Zom-B
 */
// Created 2018-01-20
@StaticClass
public final class HeaderIO {
	private HeaderIO() {
		throw new AssertionError();
	}

	public static final int HEADER_SIZE = 12;

	public static Header read(ReadableByteChannel handle) throws IOException {
		FileBuffer buffer = new FileBuffer(HEADER_SIZE);
		buffer.readFrom(handle);
		buffer.flip();

		String identification  = buffer.getString(4);
		int    numLumps        = buffer.getInt();
		int    infoTableOffset = buffer.getInt();

		return new Header(identification, numLumps, infoTableOffset);
	}

	public static void write(Header header, WritableByteChannel handle) throws IOException {
		FileBuffer buffer = new FileBuffer(12);

		buffer.putString(header.getIdentification(), 4);
		buffer.putInt(header.getNumLumps());
		buffer.putInt(header.getInfoTableOffset());
		buffer.flip();

		buffer.writeTo(handle);

	}
}
