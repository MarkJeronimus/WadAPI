package wadapi.lump;

import java.util.ArrayList;
import java.util.List;

import wadapi.LumpType;
import wadapi.structure.MapTexture;
import static wadapi.LumpType.TEXTUREX;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class MapTexturesLump extends Lump {
	private final List<MapTexture> textures;

	public MapTexturesLump(String name, int initialCapacity) {
		super(name);

		textures = new ArrayList<>(initialCapacity);
	}

	public List<MapTexture> getTextures() {
		return textures;
	}

	@Override
	public LumpType getLumpType() {
		return TEXTUREX;
	}
}
