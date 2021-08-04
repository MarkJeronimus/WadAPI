package wadapi.codec;

import java.util.List;

import org.digitalmodular.utilities.annotation.Singleton;

import wadapi.FileBuffer;
import wadapi.lump.FileBufferLump;
import wadapi.lump.PatchNamesLump;

/**
 * @author Zom-B
 */
// Created 2011-08-04
@Singleton
public class PatchNamesCodec extends LumpCodec<PatchNamesLump> {
	public static final PatchNamesCodec INSTANCE = new PatchNamesCodec();

	public PatchNamesCodec() {
		super(PatchNamesLump.class);
	}

	@Override
	public PatchNamesLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numPatchNames = fileBuffer.getInt();

		PatchNamesLump patchNamesLump = new PatchNamesLump(lump.getName(), numPatchNames);

		List<String> patchNames = patchNamesLump.getPatchNames();
		for (int i = 0; i < numPatchNames; i++) {
			String patchName = fileBuffer.getString(8);
			patchNames.add(patchName);
		}

		return patchNamesLump;
	}

	@Override
	public void encode(PatchNamesLump patchNamesLump, FileBuffer buffer) {
		List<String> patchNames = patchNamesLump.getPatchNames();

		buffer.putInt(patchNames.size());
		for (String patchName : patchNames)
			buffer.putString(patchName, 8);
	}
}
