package org.digitalmodular.wadapi.structure;

/**
 * @author Zom-B
 */
// Created 2018-01-26
public class Thing {
	private int x;
	private int y;
	private int angle;
	private int type;
	private int flags;

	public Thing(int x, int y, int angle, int type, int flags) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.type = type;
		this.flags = flags;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getFlags() {
		return flags;
	}

	public void setFlags(int flags) {
		this.flags = flags;
	}

	@Override
	public String toString() {
		return "[" + getType()
		       + ", x=" + getX() / 65536.0
		       + ", y=" + getY() / 65536.0
		       + ", angle=" + getAngle() * 180.0f / 2147483648.0f
		       + ", flags=" + getFlags()
		       + ']';
	}
}
