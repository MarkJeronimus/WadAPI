package org.digitalmodular.wadapi.structure;

/**
 * A Linedef, as used for editing, and as input to the BSP builder.
 *
 * @author Zom-B
 */
// Created 2011-08-14
public abstract class Linedef {
	public static final int NO_SIDEDEF = -1;

	public static final int FLAG_IMPASSABLE     = 0x0001;
	public static final int FLAG_BLOCK_MONSTER  = 0x0002;
	public static final int FLAG_DOUBLE_SIDED   = 0x0004;
	public static final int FLAG_UPPER_UNPEGGED = 0x0008;
	public static final int FLAG_LOWER_UNPEGGED = 0x0010;
	public static final int FLAG_SECRET         = 0x0020;
	public static final int FLAG_BLOCK_SOUND    = 0x0040;
	public static final int FLAG_HIDDEN         = 0x0080;
	public static final int FLAG_SHOWN          = 0x0100;

	private int vertexFrom;
	private int vertexTo;
	private int flags;
	private int frontSidedef; // "Right" side
	private int backSidedef;  // "Left" side

	protected Linedef(int vertexFrom, int vertexTo, int flags, int frontSidedef, int backSidedef) {
		this.vertexFrom = vertexFrom;
		this.vertexTo = vertexTo;
		this.flags = flags;
		this.frontSidedef = frontSidedef;
		this.backSidedef = backSidedef;
	}

	public int getVertexFrom() {
		return vertexFrom;
	}

	public void setVertexFrom(int vertexFrom) {
		this.vertexFrom = vertexFrom;
	}

	public int getVertexTo() {
		return vertexTo;
	}

	public void setVertexTo(int vertexTo) {
		this.vertexTo = vertexTo;
	}

	public int getFlags() {
		return flags;
	}

	public void setFlags(int flags) {
		this.flags = flags;
	}

	public boolean isImpassable() {
		return (getFlags() & FLAG_IMPASSABLE) != 0;
	}

	public boolean isBlock_monster() {
		return (getFlags() & FLAG_BLOCK_MONSTER) != 0;
	}

	public boolean isDouble_sided() {
		return (getFlags() & FLAG_DOUBLE_SIDED) != 0;
	}

	public boolean isUpper_unpegged() {
		return (getFlags() & FLAG_UPPER_UNPEGGED) != 0;
	}

	public boolean isLower_unpegged() {
		return (getFlags() & FLAG_LOWER_UNPEGGED) != 0;
	}

	public boolean isSecret() {
		return (getFlags() & FLAG_SECRET) != 0;
	}

	public boolean isBlock_sound() {
		return (getFlags() & FLAG_BLOCK_SOUND) != 0;
	}

	public boolean isHidden() {
		return (getFlags() & FLAG_HIDDEN) != 0;
	}

	public boolean isShown() {
		return (getFlags() & FLAG_SHOWN) != 0;
	}

	public int getFrontSidedef() {
		return frontSidedef;
	}

	public void setFrontSidedef(int frontSidedef) {
		this.frontSidedef = frontSidedef;
	}

	public int getBackSidedef() {
		return backSidedef;
	}

	public void setBackSidedef(int backSidedef) {
		this.backSidedef = backSidedef;
	}

	public void flip() {
		int temp = vertexFrom;
		vertexFrom = vertexTo;
		vertexTo = temp;

		temp = frontSidedef;
		frontSidedef = backSidedef;
		backSidedef = temp;
	}
}
