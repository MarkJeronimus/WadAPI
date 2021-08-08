package wadapi.structure;

/**
 * @author Zom-B
 */
// Created 2011-09-12
public class Sidedef {
	private int    xOffset;       // 2 textureoffset
	private int    yOffset;       // 2 rowoffset
	private String topTexture;    // 8
	private String bottomTexture; // 8
	private String midTexture;    // 8
	private int    sectorID;      // 2

	public Sidedef(int xOffset,
	               int yOffset,
	               String topTexture,
	               String bottomTexture,
	               String midTexture,
	               int sectorID) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.topTexture = topTexture;
		this.bottomTexture = bottomTexture;
		this.midTexture = midTexture;
		this.sectorID = sectorID;
	}

	public int getXOffset() {
		return xOffset;
	}

	public void setXOffset(int xOffset) {
		this.xOffset = xOffset;
	}

	public int getYOffset() {
		return yOffset;
	}

	public void setYOffset(int yOffset) {
		this.yOffset = yOffset;
	}

	public String getTopTexture() {
		return topTexture;
	}

	public void setTopTexture(String topTexture) {
		this.topTexture = topTexture;
	}

	public String getBottomTexture() {
		return bottomTexture;
	}

	public void setBottomTexture(String bottomTexture) {
		this.bottomTexture = bottomTexture;
	}

	public String getMidTexture() {
		return midTexture;
	}

	public void setMidTexture(String midTexture) {
		this.midTexture = midTexture;
	}

	public int getSectorID() {
		return sectorID;
	}

	public void setSectorID(int sectorID) {
		this.sectorID = sectorID;
	}

	public boolean equals(Sidedef other) {
		if (xOffset != other.xOffset)
			return false;
		if (yOffset != other.yOffset)
			return false;
		if (!topTexture.equals(other.topTexture))
			return false;
		if (!bottomTexture.equals(other.bottomTexture))
			return false;
		if (!midTexture.equals(other.midTexture))
			return false;
		if (sectorID != other.sectorID)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "[" + xOffset + ", " + yOffset + ", " + topTexture + ", " + bottomTexture + ", " + midTexture + ", " +
		       sectorID
		       + ']';
	}
}
