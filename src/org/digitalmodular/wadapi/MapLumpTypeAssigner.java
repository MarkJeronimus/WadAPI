package org.digitalmodular.wadapi;

import java.util.List;
import java.util.Set;

import org.digitalmodular.wadapi.lump.FileBufferLump;

/**
 * @author Zom-B
 */
// Created 2021-08-01
public class MapLumpTypeAssigner extends LumpTypeAssigner {
	private static final Set<LumpType> MANDATORY_MAP_LUMPS = Set.of(LumpType.THINGS,
	                                                                LumpType.LINEDEFS,
	                                                                LumpType.SIDEDEFS,
	                                                                LumpType.VERTEXES,
	                                                                LumpType.SECTORS);

	private static final List<Set<LumpType>> MAP_LUMP_ORDER = List.of(Set.of(LumpType.THINGS,
	                                                                         LumpType.LINEDEFS,
	                                                                         LumpType.SIDEDEFS,
	                                                                         LumpType.VERTEXES,
	                                                                         LumpType.SEGS,
	                                                                         LumpType.SSECTORS,
	                                                                         LumpType.NODES,
	                                                                         LumpType.SECTORS,
	                                                                         LumpType.REJECT,
	                                                                         LumpType.BLOCKMAP),
	                                                                  Set.of(LumpType.SCRIPTS,
	                                                                         LumpType.BEHAVIOR));

	@Override
	public void assignNamedLumps(List<FileBufferLump> lumps) {
		int mapMarkerCandidateIndex = -1;
		int mandatoryLumpsFound     = 0;
		int mapStep                 = 0;

		for (int i = 0; i < lumps.size(); i++) {
			FileBufferLump lump     = lumps.get(i);
			LumpType       lumpType = lump.getLumpType();

			if (MANDATORY_MAP_LUMPS.contains(lumpType)) {
				mandatoryLumpsFound++;
				if (mandatoryLumpsFound == MANDATORY_MAP_LUMPS.size())
					applyLumpType(lumps, mapMarkerCandidateIndex, LumpType.MAP);
			}

			while (!MAP_LUMP_ORDER.get(mapStep).contains(lumpType)) {
				mapStep++;
				if (mapStep >= MAP_LUMP_ORDER.size()) {
					mapMarkerCandidateIndex = lumpType == LumpType.UNASSIGNED ? i : 0;
					mandatoryLumpsFound = 0;
					mapStep = 0;
					break;
				}
			}
		}
	}
}
