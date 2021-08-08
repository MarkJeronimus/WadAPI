package wadapi.io;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Level.FINER;
import static java.util.logging.Level.FINEST;

import wadapi.FileBuffer;
import wadapi.LumpType;
import wadapi.LumpTypeAssigner;
import wadapi.MapLumpTypeAssigner;
import wadapi.NamedLumpTypeAssigner;
import wadapi.SectionLumpTypeAssigner;
import wadapi.WadFile;
import wadapi.WadType;
import wadapi.lump.FileBufferLump;
import wadapi.lump.Lump;

/**
 * Example usage:
 * <pre>{@code WadStorage storage = new WadStorage(); // This internally uses WadFileIO
 * storage.add(Paths.get("DOOM2.WAD"));
 * WadMap map = storage.getMap("MAP01");
 * }</pre>
 *
 * @author Zom-B
 */
// Created 2011-08-01
public final class WadFileIO {
	private WadFileIO() {
		throw new AssertionError();
	}

	private static final List<LumpTypeAssigner> DEFAULT_LUMP_TYPE_ASSIGNERS = List.of(
			new NamedLumpTypeAssigner(),
			new SectionLumpTypeAssigner(),
			new MapLumpTypeAssigner());

	public static WadFile read(Path file) throws IOException {
		if (!Files.isRegularFile(file))
			throw new IllegalArgumentException("WAD file " + file + " doesn't exist.");

		try (FileChannel handle = FileChannel.open(file, StandardOpenOption.READ)) {
			Header               header    = readHeader(handle);
			InfoTable            infoTable = readInfoTable(handle, header);
			List<FileBufferLump> lumps     = readLumps(handle, infoTable);

			WadFile wadFile = makeWadFile(header, lumps, infoTable);
			return wadFile;
		}
	}

	private static Header readHeader(SeekableByteChannel handle) throws IOException {
		handle.position(0);
		return HeaderIO.read(handle);
	}

	private static InfoTable readInfoTable(SeekableByteChannel handle, Header header) throws IOException {
		handle.position(header.getInfoTableOffset());
		return InfoTableIO.read(handle, header.getNumLumps());
	}

	private static List<FileBufferLump> readLumps(SeekableByteChannel handle, InfoTable infoTable)
			throws IOException {
		List<FileBufferLump> lumps = readProtoLumps(handle, infoTable);

		DEFAULT_LUMP_TYPE_ASSIGNERS.forEach(a -> a.assignNamedLumps(lumps));

		return lumps;
	}

	private static List<FileBufferLump> readProtoLumps(SeekableByteChannel handle, InfoTable infoTable)
			throws IOException {
		List<FileBufferLump> protoLumps = new ArrayList<>(infoTable.numLumps());

		for (InfoTableEntry entry : infoTable) {
			FileBufferLump lump = readProtoLump(handle, entry, LumpType.UNASSIGNED);
			protoLumps.add(lump);
		}

		return protoLumps;
	}

	private static FileBufferLump readProtoLump(
			SeekableByteChannel handle, InfoTableEntry entry, LumpType lumpType) throws IOException {
		int    offset = entry.getOffset();
		int    length = entry.getLength();
		String name   = entry.getName();

		handle.position(offset);

		FileBuffer buffer = new FileBuffer(length);
		buffer.readFrom(handle);
		buffer.flip();

		FileBufferLump lump = new FileBufferLump(name, lumpType, buffer);
		return lump;
	}

	private static WadFile makeWadFile(Header header, Iterable<FileBufferLump> lumps, InfoTable infoTable) {
		WadFile wadFile = new WadFile(WadType.valueOf(header.getIdentification()), infoTable.numLumps());

		for (FileBufferLump lump : lumps) {
			wadFile.add(lump);

			if (Logger.getGlobal().isLoggable(FINEST))
				Logger.getGlobal().log(FINER, "Loaded " + lump);
		}

		return wadFile;
	}

	public static void write(WadFile wadFile, Path file) throws IOException {
		checkMaximumFileSize(wadFile);
		checkCanOverwrite(file);

		try (FileChannel handle = FileChannel.open(file, StandardOpenOption.WRITE)) {
			InfoTable infoTable = writeLumpsAndConstructInfoTable(wadFile, handle);

			int infoTableOffset = (int)handle.position();

			InfoTableIO.write(infoTable, handle);

			Header header = new Header(wadFile.getWadType().name(), wadFile.numLumps(), infoTableOffset);

			handle.position(0);
			writeHeader(header, handle);
		}
	}

	private static void checkMaximumFileSize(WadFile wadFile) throws IOException {
//		long fileSize = calculateFileSize(wadFile);
//		if (fileSize > Integer.MAX_VALUE)
//			throw new IOException("Can't write wad files of 2GiB or larger (size in memory = " +
//			                      new DecimalFormat(",000").format(fileSize) + ')');
	}

	private static void checkCanOverwrite(Path file) {
		if (Files.exists(file)) {
			if (!Files.isWritable(file))
				throw new IllegalArgumentException("WAD file " + file + " exists and cannot be written to.");

			try {
				Files.delete(file);
			} catch (IOException | SecurityException ex) {
				throw new IllegalArgumentException("WAD file " + file + " exists and cannot be deleted.", ex);
			}
		}
	}

	private static void writeHeader(Header header, WritableByteChannel handle) throws IOException {
		HeaderIO.write(header, handle);
	}

	private static long calculateFileSize(Collection<FileBufferLump> lumps) {
		long size = HeaderIO.HEADER_SIZE;

		int numLumps = lumps.size();
		for (FileBufferLump lump : lumps)
			size += lump.getSize();

		size += (long)numLumps * InfoTableEntry.INFO_TABLE_ENTRY_SIZE;
		return size;
	}

	private static InfoTable writeLumpsAndConstructInfoTable(WadFile wadFile, SeekableByteChannel handle)
			throws IOException {
		int offset = HeaderIO.HEADER_SIZE;
		handle.position(offset);

		int numLumps = wadFile.numLumps();

		InfoTable infoTable = new InfoTable(numLumps);

		for (Lump lump : wadFile) {
			writeLump(lump, handle);

			int offsetAfter = (int)handle.position();
			infoTable.add(new InfoTableEntry(offset, offsetAfter - offset, lump.getName()));

			offset = offsetAfter;
		}

		return infoTable;
	}

	private static void writeLump(Lump lump, SeekableByteChannel handle) {
//		try {
//
//			FileBuffer buffer = new FileBuffer(lump.);
//
//			lump.saveTo(array);
//		} catch (IllegalArgumentException e) {
//			System.out.println("Warning: Save not implemented: " + lump.getClass().getSimpleName()
//			                   + ". Entry saved as 0 length.");
//		}
	}
}
