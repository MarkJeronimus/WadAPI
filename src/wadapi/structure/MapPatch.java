package wadapi.structure;

/**
 * @author Zom-B
 */
// Created 2017-08-31
public class MapPatch {
	private int originX;  // 2
	private int originY;  // 2
	private int patch;    // 2
	//	private int stepDir;  // 2 Obsolete
	//	private int colorMap; // 2 Obsolete

	public MapPatch(int originX, int originY, int patch) {
		this.originX = originX;
		this.originY = originY;
		this.patch = patch;
	}

	public int getOriginX() {
		return originX;
	}

	public void setOriginX(int originX) {
		this.originX = originX;
	}

	public int getOriginY() {
		return originY;
	}

	public void setOriginY(int originY) {
		this.originY = originY;
	}

	public int getPatch() {
		return patch;
	}

	public void setPatch(int patch) {
		this.patch = patch;
	}

	@Override
	public String toString() {
		return "MapPatch{" +
		       "originX=" + originX +
		       ", originY=" + originY +
		       ", patch=" + patch +
		       '}';
	}
}
