package org.digitalmodular.wadapi.structure;

/**
 * @author Zom-B
 */
// Created 2011-09-12
public class Sector {
	private int    floorHeight;
	private int    ceilingHeight;
	private String floorPic;
	private String ceilingPic;
	private int    lightLevel;
	private int    special;
	private int    tag;

	public Sector(int floorHeight,
	              int ceilingHeight,
	              String floorPic,
	              String ceilingPic,
	              int lightLevel,
	              int special,
	              int tag) {
		this.floorHeight = floorHeight;
		this.ceilingHeight = ceilingHeight;
		this.floorPic = floorPic;
		this.ceilingPic = ceilingPic;
		this.lightLevel = lightLevel;
		this.special = special;
		this.tag = tag;
	}

	public int getFloorHeight() {
		return floorHeight;
	}

	public void setFloorHeight(int floorHeight) {
		this.floorHeight = floorHeight;
	}

	public int getCeilingHeight() {
		return ceilingHeight;
	}

	public void setCeilingHeight(int ceilingHeight) {
		this.ceilingHeight = ceilingHeight;
	}

	public String getFloorPic() {
		return floorPic;
	}

	public void setFloorPic(String floorPic) {
		this.floorPic = floorPic;
	}

	public String getCeilingPic() {
		return ceilingPic;
	}

	public void setCeilingPic(String ceilingPic) {
		this.ceilingPic = ceilingPic;
	}

	public int getLightLevel() {
		return lightLevel;
	}

	public void setLightLevel(int lightLevel) {
		this.lightLevel = lightLevel;
	}

	public int getSpecial() {
		return special;
	}

	public void setSpecial(int special) {
		this.special = special;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public boolean equals(Sector other) {
		if (floorHeight != other.floorHeight)
			return false;
		if (ceilingHeight != other.ceilingHeight)
			return false;
		if (!floorPic.equals(other.floorPic))
			return false;
		if (!ceilingPic.equals(other.ceilingPic))
			return false;
		if (lightLevel != other.lightLevel)
			return false;
		if (special != other.special)
			return false;
		if (tag != other.tag)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "[(" + floorHeight + ", " + ceilingHeight + "), (" + floorPic + ", " + ceilingPic + "), " + lightLevel +
		       ", " + special + ", " + tag + ']';
	}
}
