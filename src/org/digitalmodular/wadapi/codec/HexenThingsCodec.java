package org.digitalmodular.wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.LumpUtilities;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.ThingsLump;
import org.digitalmodular.wadapi.structure.HexenThing;
import org.digitalmodular.wadapi.structure.Thing;

/**
 * @author Zom-B
 */
// Created 2021-08-08
@Singleton
public class HexenThingsCodec extends LumpCodec<ThingsLump> {
	public static final int THING_FIELD_SIZE = 20;

	public static final HexenThingsCodec INSTANCE = new HexenThingsCodec();

	@Override
	public ThingsLump decode(FileBufferLump lump) {
		String     name       = lump.getName();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numThings = LumpUtilities.calcNumFields(fileBuffer.remaining(), THING_FIELD_SIZE, name);

		ThingsLump thingsLump = new ThingsLump(name, numThings);

		for (int i = 0; i < numThings; i++) {
			HexenThing thing = readThing(fileBuffer);
			thingsLump.add(thing);
		}

		return thingsLump;
	}

	@Override
	public void encode(ThingsLump thingsLump, FileBuffer buffer) {
		for (Thing thing : thingsLump) {
			if (!(thing instanceof HexenThing))
				throw new IllegalArgumentException("Not all things are " + HexenThing.class.getSimpleName() + ": " +
				                                   thing.getClass());

			writeThing((HexenThing)thing, buffer);
		}
	}

	private static HexenThing readThing(FileBuffer buffer) {
		int tid     = buffer.getUnsignedShort();
		int x       = buffer.getShort();
		int y       = buffer.getShort();
		int z       = buffer.getShort();
		int angle   = buffer.getUnsignedShort();
		int type    = buffer.getUnsignedShort();
		int flags   = buffer.getUnsignedShort();
		int special = buffer.getUnsignedByte();
		int ar1     = buffer.getUnsignedByte();
		int ar2     = buffer.getUnsignedByte();
		int ar3     = buffer.getUnsignedByte();
		int ar4     = buffer.getUnsignedByte();
		int ar5     = buffer.getUnsignedByte();

		return new HexenThing(tid,
		                      x << 16,
		                      y << 16,
		                      z << 16,
		                      (int)(angle * 0x80000000L / 180),
		                      type,
		                      flags,
		                      special,
		                      ar1,
		                      ar2,
		                      ar3,
		                      ar4,
		                      ar5);
	}

	private static void writeThing(HexenThing thing, FileBuffer buffer) {
		throw new UnsupportedOperationException("Not implemented: " + HexenThingsCodec.class.getSimpleName() +
		                                        ".writeHexenThing()");
	}
}
