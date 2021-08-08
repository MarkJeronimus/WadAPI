package wadapi;

import java.util.List;

import wadapi.lump.FileBufferLump;

/**
 * @author Zom-B
 */
// Created 2021-08-01
public class NamedLumpTypeAssigner extends LumpTypeAssigner {
	@Override
	public void assignNamedLumps(List<FileBufferLump> lumps) {
		assignNamedLump(lumps, LumpType.PLAYPAL.toString(), LumpType.PLAYPAL);
		assignNamedLump(lumps, LumpType.PNAMES.toString(), LumpType.PNAMES);
//		assignNamedLump(lumps, LumpType.TEXTURES.toString(), LumpType.TEXTURES);

		assignNamedLump(lumps, LumpType.THINGS.toString(), LumpType.THINGS);
		assignNamedLump(lumps, LumpType.LINEDEFS.toString(), LumpType.LINEDEFS);
		assignNamedLump(lumps, LumpType.SIDEDEFS.toString(), LumpType.SIDEDEFS);
		assignNamedLump(lumps, LumpType.VERTEXES.toString(), LumpType.VERTEXES);
		assignNamedLump(lumps, LumpType.SEGS.toString(), LumpType.SEGS);
		assignNamedLump(lumps, LumpType.SSECTORS.toString(), LumpType.SSECTORS);
		assignNamedLump(lumps, LumpType.NODES.toString(), LumpType.NODES);
		assignNamedLump(lumps, LumpType.SECTORS.toString(), LumpType.SECTORS);
		assignNamedLump(lumps, LumpType.REJECT.toString(), LumpType.REJECT);
		assignNamedLump(lumps, LumpType.BLOCKMAP.toString(), LumpType.BLOCKMAP);
		assignNamedLump(lumps, LumpType.SCRIPTS.toString(), LumpType.SCRIPTS);
		assignNamedLump(lumps, LumpType.BEHAVIOR.toString(), LumpType.BEHAVIOR);
	}

	private static void assignNamedLump(List<FileBufferLump> lumps, String name, LumpType lumpType) {
		for (int i = 0; i < lumps.size(); i++) {
			FileBufferLump lump = lumps.get(i);
			if (!lump.getName().equals(name))
				continue;

			applyLumpType(lumps, i, lumpType);
		}
	}
}
