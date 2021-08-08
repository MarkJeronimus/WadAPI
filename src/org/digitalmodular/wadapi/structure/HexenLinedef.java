package org.digitalmodular.wadapi.structure;

/**
 * @author Zom-B
 */
// Created 2018-01-25
public class HexenLinedef extends Linedef {
	private int action;
	private int ar1;
	private int ar2;
	private int ar3;
	private int ar4;
	private int ar5;

	public HexenLinedef(int vertexFrom,
	                    int vertexTo,
	                    int flags,
	                    int action,
	                    int ar1,
	                    int ar2,
	                    int ar3,
	                    int ar4,
	                    int ar5,
	                    int frontSidedef,
	                    int backSidedef) {
		super(vertexFrom, vertexTo, flags, frontSidedef, backSidedef);
		this.action = action;
		this.ar1 = ar1;
		this.ar2 = ar2;
		this.ar3 = ar3;
		this.ar4 = ar4;
		this.ar5 = ar5;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getAr1() {
		return ar1;
	}

	public void setAr1(int ar1) {
		this.ar1 = ar1;
	}

	public int getAr2() {
		return ar2;
	}

	public void setAr2(int ar2) {
		this.ar2 = ar2;
	}

	public int getAr3() {
		return ar3;
	}

	public void setAr3(int ar3) {
		this.ar3 = ar3;
	}

	public int getAr4() {
		return ar4;
	}

	public void setAr4(int ar4) {
		this.ar4 = ar4;
	}

	public int getAr5() {
		return ar5;
	}

	public void setAr5(int ar5) {
		this.ar5 = ar5;
	}
}
