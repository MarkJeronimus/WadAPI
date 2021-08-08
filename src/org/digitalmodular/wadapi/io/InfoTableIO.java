package org.digitalmodular.wadapi.io;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import org.digitalmodular.utilities.annotation.StaticClass;

import org.digitalmodular.wadapi.FileBuffer;

/**
 * @author Zom-B
 */
// Created 2018-01-20
@StaticClass
public final class InfoTableIO {
	private InfoTableIO() {
		throw new AssertionError();
	}

	public static final int INFO_TABLE_ENTRY_SIZE = 16;
	public static final int NAME_FIELD_SIZE       = 8;

	public static InfoTable read(ReadableByteChannel handle, int numLumps) throws IOException {
		FileBuffer buffer = new FileBuffer(numLumps * INFO_TABLE_ENTRY_SIZE);
		buffer.readFrom(handle);
		buffer.flip();

		InfoTable infoTable = new InfoTable(numLumps);

		for (int i = 0; i < numLumps; i++) {
			int    offset   = buffer.getInt();
			int    length   = buffer.getInt();
			String lumpName = buffer.getString(NAME_FIELD_SIZE);

			infoTable.add(new InfoTableEntry(offset, length, lumpName));
		}

		return infoTable;
	}

	public static void write(InfoTable infoTable, WritableByteChannel handle) throws IOException {
		FileBuffer buffer = new FileBuffer(infoTable.numLumps() * INFO_TABLE_ENTRY_SIZE);

		for (InfoTableEntry entry : infoTable) {
			buffer.putInt(entry.getOffset());
			buffer.putInt(entry.getLength());
			buffer.putString(entry.getName(), NAME_FIELD_SIZE);
		}

		buffer.flip();
		buffer.writeTo(handle);
	}
}
