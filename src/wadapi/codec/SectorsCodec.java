package wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import wadapi.FileBuffer;
import wadapi.LumpUtilities;
import wadapi.lump.FileBufferLump;
import wadapi.lump.SectorsLump;
import wadapi.structure.Sector;

/**
 * @author Zom-B
 */
// Created 2011-08-15
@Singleton
public class SectorsCodec extends LumpCodec<SectorsLump> {
	public static final int SECTOR_FIELD_SIZE = 26;

	public static final SectorsCodec INSTANCE = new SectorsCodec();

	public SectorsCodec() {
		super(SectorsLump.class);
	}

	@Override
	public SectorsLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer = lump.getFileBuffer();
		int        numSectors = LumpUtilities.calcNumFields(fileBuffer.remaining(), SECTOR_FIELD_SIZE, lump.getName());

		SectorsLump sectorsLump = new SectorsLump(lump.getName(), numSectors);

		for (int i = 0; i < numSectors; i++) {
			Sector sector = readSector(fileBuffer);
			sectorsLump.add(sector);
		}

		return sectorsLump;
	}

	@Override
	public void encode(SectorsLump sectorsLump, FileBuffer buffer) {
		for (Sector linedef : sectorsLump)
			writeSector(linedef, buffer);
	}

	private static Sector readSector(FileBuffer buffer) {
		short  floorHeight   = buffer.getShort();
		short  ceilingHeight = buffer.getShort();
		String floorPic      = buffer.getString(8);
		String ceilingPic    = buffer.getString(8);
		short  lightLevel    = buffer.getShort();
		int    special       = buffer.getUnsignedShort();
		int    tag           = buffer.getUnsignedShort();

		return new Sector(floorHeight, ceilingHeight, floorPic, ceilingPic, lightLevel, special, tag);
	}

	private static void writeSector(Sector linedef, FileBuffer buffer) {
		buffer.putShort(linedef.getFloorHeight());
		buffer.putShort(linedef.getCeilingHeight());
		buffer.putString(linedef.getFloorPic(), 8);
		buffer.putString(linedef.getCeilingPic(), 8);
		buffer.putShort(linedef.getLightLevel());
		buffer.putUnsignedShort(linedef.getSpecial());
		buffer.putUnsignedShort(linedef.getTag());
	}
}
