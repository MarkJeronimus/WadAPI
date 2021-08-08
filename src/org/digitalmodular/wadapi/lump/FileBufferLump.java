package org.digitalmodular.wadapi.lump;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.LumpType;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class FileBufferLump extends Lump {
	private final FileBuffer fileBuffer;

	public FileBufferLump(String name, LumpType lumpType, FileBuffer fileBuffer) {
		super(name, lumpType);

		this.fileBuffer = requireNonNull(fileBuffer, "fileBuffer");
	}

	public FileBuffer getFileBuffer() {
		return fileBuffer;
	}

	public int getSize() {
		return fileBuffer.capacity();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + '[' + getName() + ", " + getLumpType() +
		       "] (" + getFileBuffer().capacity() + " bytes)";
	}
}
