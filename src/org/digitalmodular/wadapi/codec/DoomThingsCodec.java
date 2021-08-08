package org.digitalmodular.wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.LumpUtilities;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.ThingsLump;
import org.digitalmodular.wadapi.structure.DoomThing;
import org.digitalmodular.wadapi.structure.Thing;

/**
 * @author Zom-B
 */
// Created 2011-08-02
@Singleton
public class DoomThingsCodec extends LumpCodec<ThingsLump> {
	public static final int THING_FIELD_SIZE = 10;

	public static final DoomThingsCodec INSTANCE = new DoomThingsCodec();

	@Override
	public ThingsLump decode(FileBufferLump lump) {
		String     name       = lump.getName();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numThings = LumpUtilities.calcNumFields(fileBuffer.remaining(), THING_FIELD_SIZE, name);

		ThingsLump thingsLump = new ThingsLump(name, numThings);

		for (int i = 0; i < numThings; i++) {
			DoomThing thing = readThing(fileBuffer);
			thingsLump.add(thing);
		}

		return thingsLump;
	}

	@Override
	public void encode(ThingsLump thingsLump, FileBuffer buffer) {
		for (Thing thing : thingsLump) {
			if (!(thing instanceof DoomThing))
				throw new IllegalArgumentException("Not all things are " + DoomThing.class.getSimpleName() + ": " +
				                                   thing.getClass());

			writeThing((DoomThing)thing, buffer);
		}
	}

	private static DoomThing readThing(FileBuffer buffer) {
		int x     = buffer.getShort();
		int y     = buffer.getShort();
		int angle = buffer.getUnsignedShort();
		int type  = buffer.getUnsignedShort();
		int flags = buffer.getUnsignedShort();

		return new DoomThing(x << 16,
		                     y << 16,
		                     (int)(angle * 0x80000000L / 180),
		                     type,
		                     flags);
	}

	private static void writeThing(DoomThing thing, FileBuffer buffer) {
		buffer.putShort((short)thing.getX());
		buffer.putShort((short)thing.getY());
		buffer.putUnsignedShort((int)(thing.getAngle() * 180L / 0x80000000L));
		buffer.putUnsignedShort(thing.getType());
		buffer.putUnsignedShort(thing.getFlags());
	}
}
