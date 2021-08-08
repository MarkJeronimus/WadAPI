package org.digitalmodular.wadapi.lump;

import java.util.ArrayList;
import java.util.List;

import org.digitalmodular.wadapi.LumpType;
import org.digitalmodular.wadapi.structure.MapTexture;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class MapTexturesLump extends Lump {
	private final List<MapTexture> textures;

	public MapTexturesLump(String name, int initialCapacity) {
		super(name, LumpType.TEXTUREX);

		textures = new ArrayList<>(initialCapacity);
	}

	public List<MapTexture> getTextures() {
		return textures;
	}
}
