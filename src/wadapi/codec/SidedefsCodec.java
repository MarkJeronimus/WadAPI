package wadapi.codec;

import java.util.List;

import org.digitalmodular.utilities.annotation.Singleton;

import wadapi.FileBuffer;
import wadapi.io.WadIOUtilities;
import wadapi.lump.FileBufferLump;
import wadapi.lump.SidedefsLump;
import wadapi.structure.Sidedef;

/**
 * @author Zom-B
 */
// Created 2011-09-12
@Singleton
public class SidedefsCodec extends LumpCodec<SidedefsLump> {
	public static final int SIDEDEF_FIELD_SIZE = 30;

	public static final SidedefsCodec INSTANCE = new SidedefsCodec();

	public SidedefsCodec() {
		super(SidedefsLump.class);
	}

	@Override
	public SidedefsLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer  = lump.getFileBuffer();
		int        numSidedefs = WadIOUtilities.calcNumFields(fileBuffer.remaining(), SIDEDEF_FIELD_SIZE, lump.getName());

		SidedefsLump sideDefsLump = new SidedefsLump(lump.getName(), numSidedefs);

		List<Sidedef> sidedefs = sideDefsLump.getSidedefs();
		for (int i = 0; i < numSidedefs; i++) {
			Sidedef sidedef = readSidedef(fileBuffer);
			sidedefs.add(sidedef);
		}

		return sideDefsLump;
	}

	@Override
	public void encode(SidedefsLump sideDefsLump, FileBuffer buffer) {
		List<Sidedef> sidedefs = sideDefsLump.getSidedefs();
		for (Sidedef sideDef : sidedefs)
			writeSidedef(sideDef, buffer);
	}

	private static Sidedef readSidedef(FileBuffer buffer) {
		short  xOffset       = buffer.getShort();
		short  yOffset       = buffer.getShort();
		String topTexture    = buffer.getString(8);
		String bottomTexture = buffer.getString(8);
		String midTexture    = buffer.getString(8);
		int    sectorID      = buffer.getUnsignedShort();
		return new Sidedef(xOffset, yOffset, topTexture, bottomTexture, midTexture, sectorID);
	}

	private static void writeSidedef(Sidedef sideDef, FileBuffer buffer) {
		buffer.putShort(sideDef.getXOffset());
		buffer.putShort(sideDef.getYOffset());
		buffer.putString(sideDef.getTopTexture(), 8);
		buffer.putString(sideDef.getBottomTexture(), 8);
		buffer.putString(sideDef.getMidTexture(), 8);
		buffer.putShort(sideDef.getSectorID());
	}
}
