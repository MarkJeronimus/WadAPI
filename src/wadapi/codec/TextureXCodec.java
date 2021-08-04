package wadapi.codec;

import java.util.List;

import org.digitalmodular.utilities.annotation.Singleton;

import wadapi.FileBuffer;
import wadapi.lump.FileBufferLump;
import wadapi.lump.MapTexturesLump;
import wadapi.structure.MapPatch;
import wadapi.structure.MapTexture;

/**
 * @author Zom-B
 */
// Created 2011-08-04
@Singleton
public class TextureXCodec extends LumpCodec<MapTexturesLump> {
	public static final TextureXCodec INSTANCE = new TextureXCodec();

	public TextureXCodec() {
		super(MapTexturesLump.class);
	}

	@Override
	public MapTexturesLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numTextures = fileBuffer.getInt();

		int[] directory = new int[numTextures];
		for (int i = 0; i < numTextures; i++)
			directory[i] = fileBuffer.getInt();

		MapTexturesLump mapTexturesLump = new MapTexturesLump(lump.getName(), numTextures);

		List<MapTexture> mapTextures = mapTexturesLump.getTextures();
		for (int i = 0; i < numTextures; i++) {
			fileBuffer.position(directory[i]);
			MapTexture mapTexture = readMapTexture(fileBuffer);
			mapTextures.add(mapTexture);
		}

		return mapTexturesLump;
	}

	@Override
	public void encode(MapTexturesLump mapTexturesLump, FileBuffer buffer) {
		List<MapTexture> mapTextures = mapTexturesLump.getTextures();

		int numTextures = mapTextures.size();

		buffer.putInt(numTextures);

		int offset = 4 + 4 * numTextures;
		for (MapTexture mapTexture : mapTextures) {
			buffer.putInt(offset);

			offset += mapTexture.getSize();
		}

		for (MapTexture mapTexture : mapTextures)
			writeMapTexture(mapTexture, buffer);
	}

	private static MapTexture readMapTexture(FileBuffer buffer) {
		String  name   = buffer.getString(8);
		boolean masked = buffer.getBoolean();
		int     width  = buffer.getShort();
		int     height = buffer.getShort();
		buffer.skip(4); // Skip over obsolete columnDirectory
		int patchCount = buffer.getShort();

		MapPatch[] patches = new MapPatch[patchCount];
		for (int i = 0; i < patchCount; i++)
			patches[i] = readMapPatch(buffer);

		return new MapTexture(name, masked, width, height, patches);
	}

	private static void writeMapTexture(MapTexture mapTexture, FileBuffer buffer) {
		MapPatch[] patches = mapTexture.getPatches();

		buffer.putString(mapTexture.getName(), 8);
		buffer.putBoolean(mapTexture.isMasked());
		buffer.putShort(mapTexture.getWidth());
		buffer.putShort(mapTexture.getHeight());
		buffer.putInt(0); // Skip over obsolete columnDirectory
		buffer.putShort(patches.length);

		for (MapPatch patch : patches)
			writeMapPatch(patch, buffer);
	}

	private static MapPatch readMapPatch(FileBuffer buffer) {
		int originX = buffer.getShort();
		int originY = buffer.getShort();
		int patch   = buffer.getShort();
		buffer.skip(4);

		return new MapPatch(originX, originY, patch);
	}

	private static void writeMapPatch(MapPatch patch, FileBuffer buffer) {
		buffer.putShort(patch.getOriginX());
		buffer.putShort(patch.getOriginY());
		buffer.putShort(patch.getPatch());
		buffer.putInt(0);  // Skip over obsolete stepdir & colormap
	}
}
