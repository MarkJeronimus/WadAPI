package wadapi;

import java.util.List;

import wadapi.lump.FileBufferLump;

/**
 * @author Zom-B
 */
// Created 2021-08-01
public class MapLumpTypeAssigner extends LumpTypeAssigner {
	@Override
	public void assignNamedLumps(List<FileBufferLump> lumps) {
		int mapMarkerCandidateIndex = -1;

		for (int i = 0; i < lumps.size(); i++) {
			FileBufferLump lump     = lumps.get(i);
			LumpType       lumpType = lump.getLumpType();

			if (lumpType == LumpType.UNASSIGNED) {
				mapMarkerCandidateIndex = i;
				continue;
			}

			if (mapMarkerCandidateIndex >= 0) {
				if (isOptionalMapLump(lumpType))
					continue;

				if (isMandatoryMapLump(lumpType))
					applyLumpType(lumps, mapMarkerCandidateIndex, LumpType.MAP);

				mapMarkerCandidateIndex = -1;
			}
		}
	}

	private static boolean isOptionalMapLump(LumpType lumpType) {
		return lumpType == LumpType.SEGS ||
		       lumpType == LumpType.SSECTORS ||
		       lumpType == LumpType.NODES ||
		       lumpType == LumpType.REJECT ||
		       lumpType == LumpType.BLOCKMAP ||
		       lumpType == LumpType.SCRIPTS ||
		       lumpType == LumpType.BEHAVIOR;
	}

	private static boolean isMandatoryMapLump(LumpType lumpType) {
		return lumpType == LumpType.THINGS ||
		       lumpType == LumpType.LINEDEFS ||
		       lumpType == LumpType.SIDEDEFS ||
		       lumpType == LumpType.VERTEXES ||
		       lumpType == LumpType.SECTORS;
	}
}
