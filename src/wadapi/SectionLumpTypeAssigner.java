package wadapi;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Level.FINE;
import static java.util.logging.Level.FINER;
import static java.util.logging.Level.WARNING;

import wadapi.lump.FileBufferLump;

/**
 * @author Zom-B
 */
// Created 2021-08-01
public class SectionLumpTypeAssigner extends LumpTypeAssigner {
	@Override
	public void assignNamedLumps(List<FileBufferLump> lumps) {
		assignSection(lumps, "P3_START", "P3_END", LumpType.PATCH, false);
		assignSection(lumps, "P2_START", "P2_END", LumpType.PATCH, false);
		assignSection(lumps, "P1_START", "P1_END", LumpType.PATCH, false);
		assignSection(lumps, "P_START", "P_END", LumpType.PATCH, false);
		assignSection(lumps, "SS_START", "SS_END", LumpType.SPRITE, false);
		assignSection(lumps, "S_START", "S_END", LumpType.SPRITE, false);
		assignSection(lumps, "F3_START", "F3_END", LumpType.FLAT, true);
		assignSection(lumps, "F2_START", "F2_END", LumpType.FLAT, true);
		assignSection(lumps, "F1_START", "F1_END", LumpType.FLAT, true);
		assignSection(lumps, "FF_START", "FF_END", LumpType.FLAT, true);
		assignSection(lumps, "F_START", "F_END", LumpType.FLAT, true);
		assignSection(lumps, "C_START", "C_END", LumpType.COLORMAPS, false);
		assignSection(lumps, "A_START", "A_END", LumpType.ACSLIBRARY, false);
		assignSection(lumps, "TX_START", "TX_END", LumpType.NEWTEXTURES, false);
		assignSection(lumps, "V_START", "V_END", LumpType.STRIFEVOICES, false);
		assignSection(lumps, "HI_START", "HI_END", LumpType.HIRES, false);
		assignSection(lumps, "VX_START", "VX_END", LumpType.VOXELS, false);

//	    addMasks(FONT, startMarkers, "FONTA_S", "FONTAY_S", "FONTB_S");
//	    addMasks(FONT, endMarkers, "FONTA_E", "FONTAY_E", "FONTB_E");
//
//	    addMasks(TEXTUREX, lumpTypes, "TEXTURE#");
	}

	/**
	 * @param startMarker <em>e.g.</em> <tt>P_START</tt>
	 * @param endMarker   <em>e.g.</em> <tt>P_END</tt>
	 * @param flatHack    whether to detect and fix missing F_START marker
	 */
	public static void assignSection(List<FileBufferLump> lumps,
	                                 String startMarker,
	                                 String endMarker,
	                                 LumpType lumpType,
	                                 boolean flatHack) {
		int startMarkerIndex = -1;
		int endMarkerIndex   = 0;
		for (int i = 0; i < lumps.size(); i++) {
			FileBufferLump lump = lumps.get(i);

			String name = lump.getName();
			if (name.equals(startMarker)) {
				checkMarkerWithData(i, lump);
				applyLumpType(lumps, i, LumpType.MARKER);

				if (startMarkerIndex >= 0) {
					Thread.yield();
					if (Logger.getGlobal().isLoggable(FINER))
						Logger.getGlobal().log(FINER, "Found multiple " + startMarker +
						                              ". (at " + startMarkerIndex + " and " + i + ')');
				}

				startMarkerIndex = i;
			} else if (name.equals(endMarker)) {
				checkMarkerWithData(i, lump);
				applyLumpType(lumps, i, LumpType.MARKER);

				if (startMarkerIndex < 0) {
					Logger.getGlobal().log(WARNING, "Found " + endMarker + " without corresponding " + startMarker +
					                                " Marking all prior lumps with size 4096 as " + LumpType.FLAT);
					if (flatHack)
						applyFlatHack(lumps, endMarkerIndex, i, lumpType);

					return;
				}

				applyLumpType(lumps, startMarkerIndex + 1, i - 1, lumpType);

				startMarkerIndex = -1;
				endMarkerIndex = i;
			}
		}
	}

	private static void checkMarkerWithData(int i, FileBufferLump lump) {
		if (Logger.getGlobal().isLoggable(FINE)) {
			FileBuffer fileBuffer = lump.getFileBuffer();
			int        length     = fileBuffer.remaining();

			if (length == 0)
				return;

			Thread.yield();
			String name = lump.getName();

			assert length == fileBuffer.capacity();
			byte[] data = new byte[fileBuffer.remaining()];
			fileBuffer.getArray(data);
			fileBuffer.rewind();

			Logger.getGlobal().log(FINER, "Found marker lump with " + length + " bytes of data attached: " + name +
			                              " (entry " + i + ')');

			if (Logger.getGlobal().isLoggable(FINER)) {
				Logger.getGlobal().log(FINER, ">>>");
				Logger.getGlobal().log(FINER, new String(data, StandardCharsets.ISO_8859_1));
				Logger.getGlobal().log(FINER, "<<<");
				Thread.yield();
			}
		}
	}

	private static void applyFlatHack(List<FileBufferLump> lumps, int from, int endMarkerIndex, LumpType lumpType) {
		int fromIndex = -1;
		int toIndex   = -1;

		for (int i = from; i < endMarkerIndex; i++) {
			FileBufferLump lump = lumps.get(i);

			boolean potentialFlatLump = lump.getFileBuffer().remaining() == 4096;
			if (potentialFlatLump) {
				toIndex = i;
				if (fromIndex < 0)
					fromIndex = i;

				lumps.set(i, new FileBufferLump(lump.getName(), lumpType, lump.getFileBuffer()));
			} else {
				if (fromIndex >= 0) {
					applyLumpType(lumps, fromIndex, toIndex, LumpType.FLAT);
					fromIndex = -1;
				}
			}
		}

		if (fromIndex >= 0)
			applyLumpType(lumps, fromIndex, toIndex, LumpType.FLAT);

		FileBufferLump lump = lumps.get(endMarkerIndex);
		lumps.set(endMarkerIndex, new FileBufferLump(lump.getName(), LumpType.MARKER, lump.getFileBuffer()));
	}
}
