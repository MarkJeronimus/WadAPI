package wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.FileBuffer;
import wadapi.LumpUtilities;
import wadapi.MapFormat;
import wadapi.lump.FileBufferLump;
import wadapi.lump.ThingsLump;
import wadapi.structure.DoomThing;
import wadapi.structure.HexenThing;
import wadapi.structure.Thing;

/**
 * @author Zom-B
 */
// Created 2011-08-02
@Singleton
public class ThingsCodec extends LumpCodec<ThingsLump> {
	public static final int THING_FIELD_SIZE_DOOM  = 10;
	public static final int THING_FIELD_SIZE_HEXEN = 20;

	public static final ThingsCodec INSTANCE = new ThingsCodec();

	public ThingsCodec() {
		super(ThingsLump.class);
	}

	@Override
	public ThingsLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer = lump.getFileBuffer();
		int numThings =
				LumpUtilities.calcNumFields(fileBuffer.remaining(), getFieldSize(getWadFormat()), lump.getName());

		ThingsLump thingsLump = new ThingsLump(lump.getName(), numThings);

		switch (getWadFormat()) {
			case DOOM:
				for (int i = 0; i < numThings; i++) {
					DoomThing thing = readDoomThing(fileBuffer);
					thingsLump.add(thing);
				}

				break;
			case HEXEN:
				for (int i = 0; i < numThings; i++) {
					HexenThing thing = readHexenThing(fileBuffer);
					thingsLump.add(thing);
				}

				break;
			default:
				throw new AssertionError("Unimplemented: " + getWadFormat());
		}

		return thingsLump;
	}

	@Override
	public void encode(ThingsLump thingsLump, FileBuffer buffer) {
		switch (getWadFormat()) {
			case DOOM:
				for (Thing thing : thingsLump)
					writeDoomThing((DoomThing)thing, buffer);

				break;
			case HEXEN:
				for (Thing thing : thingsLump)
					writeHexenThing((HexenThing)thing, buffer);

				break;
			default:
				throw new AssertionError("Unimplemented: " + getWadFormat());
		}
	}

	public static int getFieldSize(MapFormat wadFormat) {
		switch (requireNonNull(wadFormat, "wadFormat")) {
			case DOOM:
				return THING_FIELD_SIZE_DOOM;
			case HEXEN:
				return THING_FIELD_SIZE_HEXEN;
			default:
				throw new AssertionError("Unimplemented: " + wadFormat);
		}
	}

	private static DoomThing readDoomThing(FileBuffer buffer) {
		int x     = buffer.getShort() << 16;
		int y     = buffer.getShort() << 16;
		int angle = (int)(buffer.getUnsignedShort() * 0x80000000L / 180);
		int type  = buffer.getUnsignedShort();
		int flags = buffer.getUnsignedShort();
		return new DoomThing(x, y, angle, type, flags);
	}

	private static HexenThing readHexenThing(FileBuffer buffer) {
		int tid     = buffer.getUnsignedShort();
		int x       = buffer.getShort() << 16;
		int y       = buffer.getShort() << 16;
		int z       = buffer.getShort() << 16;
		int angle   = (int)(buffer.getUnsignedShort() * 0x80000000L / 180);
		int type    = buffer.getUnsignedShort();
		int flags   = buffer.getUnsignedShort();
		int special = buffer.getUnsignedByte();
		int ar1     = buffer.getUnsignedByte();
		int ar2     = buffer.getUnsignedByte();
		int ar3     = buffer.getUnsignedByte();
		int ar4     = buffer.getUnsignedByte();
		int ar5     = buffer.getUnsignedByte();
		return new HexenThing(tid, x, y, z, angle, type, flags, special, ar1, ar2, ar3, ar4, ar5);
	}

	private static void writeDoomThing(DoomThing thing, FileBuffer buffer) {
		buffer.putShort((short)thing.getX());
		buffer.putShort((short)thing.getY());
		buffer.putUnsignedShort((int)(thing.getAngle() * 180L / 0x80000000L));
		buffer.putUnsignedShort(thing.getType());
		buffer.putUnsignedShort(thing.getFlags());
	}

	private static void writeHexenThing(HexenThing thing, FileBuffer buffer) {
		throw new UnsupportedOperationException("Not implemented: " + ThingsCodec.class.getSimpleName() +
		                                        ".writeHexenThing()");
	}
}
