package wadapi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.logging.Logger;
import static java.util.logging.Level.WARNING;

import org.jetbrains.annotations.NotNull;

/**
 * @author Zom-B
 */
// Created 2017-08-31
public final class FileBuffer {
	private static final ByteBuffer EMPTY_BYTE_BUFFER = ByteBuffer.allocate(0);

	private ByteBuffer buffer = EMPTY_BYTE_BUFFER;

	public FileBuffer(int initialLength) {
		reallocate(initialLength);
	}

	public int capacity() {
		return buffer.capacity();
	}

	public int position() {
		return buffer.position();
	}

	public Buffer position(int newPosition) {
		return buffer.position(newPosition);
	}

	public int limit() {
		return buffer.limit();
	}

	public Buffer limit(int newLimit) {
		return buffer.limit(newLimit);
	}

	public Buffer flip() {
		return buffer.flip();
	}

	public Buffer rewind() {
		return buffer.rewind();
	}

	public int remaining() {
		return buffer.remaining();
	}

	public void skip(int n) {
		buffer.position(buffer.position() + n);
	}

	public boolean getBoolean() {
		return buffer.get() != 0;
	}

	public void putBoolean(boolean v) {
		buffer.put(v ? (byte)1 : 0);
	}

	@Deprecated
	public byte getByte() {
		return buffer.get();
	}

	@Deprecated
	public void putByte(byte v) {
		buffer.put(v);
	}

	public int getUnsignedByte() {
		return buffer.get() & 0xFF;
	}

	public void putUnsignedByte(int v) {
		buffer.put((byte)v);
	}

	public short getShort() {
		return buffer.getShort();
	}

	public void putShort(int v) {
		buffer.putShort((short)v);
	}

	public int getUnsignedShort() {
		return buffer.getShort() & 0xFFFF;
	}

	public void putUnsignedShort(int v) {
		buffer.putShort((short)v);
	}

	public int getInt() {
		return buffer.getInt();
	}

	public void putInt(int v) {
		buffer.putInt(v);
	}

	@Deprecated
	public float getFloat() {
		return buffer.getFloat();
	}

	@Deprecated
	public void putFloat(float v) {
		buffer.putFloat(v);
	}

	public void getArray(byte b[]) {
		buffer.get(b);
	}

	public void putArray(@NotNull byte[] b) {
		buffer.put(b);
	}

	@Deprecated
	public void getArray(@NotNull byte[] b, int off, int len) {
		buffer.get(b, off, len);
	}

	@Deprecated
	public void putArray(@NotNull byte[] b, int off, int len) {
		buffer.put(b, off, len);
	}

	public String getString(int fieldSize) {
		byte[] bytes = new byte[fieldSize];

		int len = 0;
		for (int i = 0; i < fieldSize; i++) {
			byte c = buffer.get();

			// Stop when null-character is reached
			if (len == 0 && c == 0)
				len = i;

			bytes[i] = c;
		}

		if (len == 0)
			len = fieldSize;

		try {
			return new String(bytes, 0, len, "Cp437");
		} catch (UnsupportedEncodingException ex) {
			Logger.getGlobal().log(WARNING, ex.getMessage(), ex);
			//noinspection ImplicitDefaultCharsetUsage
			return new String(bytes, 0, len);
		}
	}

	public void putString(String string, int fieldSize) {
		byte[] bytes;
		try {
			bytes = string.getBytes("Cp437");
		} catch (UnsupportedEncodingException ex) {
			Logger.getGlobal().log(WARNING, ex.getMessage(), ex);
			//noinspection ImplicitDefaultCharsetUsage
			bytes = string.getBytes();
		}

		int stringLength = Math.min(fieldSize, bytes.length);
		for (int i = 0; i < stringLength; i++)
			buffer.put(bytes[i]);

		for (int i = stringLength; i < fieldSize; i++)
			buffer.put((byte)0);
	}

	public int getColor() {
		return 0xFF000000 |
		       getUnsignedByte() << 16 |
		       getUnsignedByte() << 8 |
		       getUnsignedByte();
	}

	public void putColor(int color) {
		putUnsignedByte(color >>> 16);
		putUnsignedByte(color >>> 8);
		putUnsignedByte(color);
	}

	public void readFrom(ReadableByteChannel in) throws IOException {
		in.read(buffer);
	}

	public void writeTo(WritableByteChannel out) throws IOException {
		out.write(buffer);
	}

	public void reallocate(int length) {
		Thread.yield();
		if (length == 0) {
			buffer = EMPTY_BYTE_BUFFER;
			return;
		}

		buffer = ByteBuffer.allocate(length);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
	}

	public void growTo(int length) {
		if (buffer.capacity() >= length)
			return;

		reallocate(length);
	}
}
