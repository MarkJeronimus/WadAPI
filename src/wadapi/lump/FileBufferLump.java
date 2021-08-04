package wadapi.lump;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.FileBuffer;
import wadapi.LumpType;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class FileBufferLump extends Lump {
	private final FileBuffer fileBuffer;
	private final LumpType   lumpType;

	public FileBufferLump(String name, LumpType lumpType, FileBuffer fileBuffer) {
		super(name);

		this.lumpType = requireNonNull(lumpType, "lumpType");
		this.fileBuffer = requireNonNull(fileBuffer, "fileBuffer");
	}

	public FileBuffer getFileBuffer() {
		return fileBuffer;
	}

	@Override
	public LumpType getLumpType() {
		return lumpType;
	}

	public int getSize() {
		return fileBuffer.capacity();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + '[' + getLumpType() + ": " + getName() +
		       "] (" + getFileBuffer().capacity() + " bytes)";
	}
}
