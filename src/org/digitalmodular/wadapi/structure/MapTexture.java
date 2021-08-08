package org.digitalmodular.wadapi.structure;

/**
 * @author Zom-B
 */
// Created 2011-08-05
public class MapTexture {
	private String     name;            // 8
	private boolean    masked;          // 4
	private int        width;           // 2
	private int        height;          // 2
	//	private int        columnDirectory; // 4 Obsolete
	//	private short      patchCount;      // 2 Implied
	private MapPatch[] patches;         // PatchLump.SIZE

	public MapTexture(String name, boolean masked, int width, int height, MapPatch[] patches) {
		this.name = name;
		this.masked = masked;
		this.width = width;
		this.height = height;
		this.patches = patches;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMasked() {
		return masked;
	}

	public void setMasked(boolean masked) {
		this.masked = masked;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public MapPatch[] getPatches() {
		return patches;
	}

	public void setPatches(MapPatch[] patches) {
		this.patches = patches;
	}

	public int getSize() {
		return 22 + patches.length * 10;
	}
}
