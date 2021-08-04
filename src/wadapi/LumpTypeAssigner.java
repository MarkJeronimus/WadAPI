package wadapi;

import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Level.FINE;
import static java.util.logging.Level.FINER;

import wadapi.lump.FileBufferLump;
import wadapi.lump.Lump;

/**
 * @author Zom-B
 */
// Created 2021-08-01 Extracted from WadFileIO
public abstract class LumpTypeAssigner {
	public abstract void assignNamedLumps(List<FileBufferLump> lumps);

	protected static void applyLumpType(List<FileBufferLump> lumps, int index, LumpType lumpType) {
		applyLumpType(lumps, index, index, lumpType);
	}

	protected static void applyLumpType(List<FileBufferLump> lumps, int startIndex, int endIndex, LumpType lumpType) {
		int numLumps = endIndex - startIndex + 1;
		if (numLumps < 1)
			return;

		if (Logger.getGlobal().isLoggable(FINER)) {
			if (numLumps == 1)
				Logger.getGlobal().log(FINER, "Assigning " + lumpType + " to lump " + startIndex +
				                              " (" + lumps.get(startIndex).getName() + ')');
			else
				Logger.getGlobal().log(FINER, "Assigning " + lumpType + " to lumps " + (startIndex + 1) + ".." +
				                              (endIndex - 1) + " (" + lumps.get(startIndex + 1).getName() +
				                              ".." + lumps.get(endIndex - 1).getName() + ')');
		}

		for (int i = startIndex; i <= endIndex; i++) {
			FileBufferLump lump = lumps.get(i);
			checkAlreadyAssigned(lump, lumpType);
			lumps.set(i, new FileBufferLump(lump.getName(), lumpType, lump.getFileBuffer()));
		}
	}

	private static void checkAlreadyAssigned(Lump lump, LumpType newLumpType) {
		if (Logger.getGlobal().isLoggable(FINE)) {
			LumpType lumpType = lump.getLumpType();
			if (lumpType == LumpType.UNASSIGNED || lumpType == LumpType.MARKER || lumpType == newLumpType)
				return;

			Thread.yield();
			Logger.getGlobal().log(FINER, "Marker is already assigned to " + lumpType);
		}
	}
}
