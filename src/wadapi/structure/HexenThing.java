package wadapi.structure;

/**
 * @author Zom-B
 */
// Created 2011-08-03
public class HexenThing extends Thing {
	private int tid;
	private int z;
	private int action;
	private int ar1;
	private int ar2;
	private int ar3;
	private int ar4;
	private int ar5;

	public HexenThing(int tid,
	                  int x,
	                  int y,
	                  int z,
	                  int angle,
	                  int type,
	                  int flags,
	                  int action,
	                  int ar1,
	                  int ar2,
	                  int ar3,
	                  int ar4,
	                  int ar5) {
		super(x, y, angle, type, flags);
		this.tid = tid;
		this.z = z;
		this.action = action;
		this.ar1 = ar1;
		this.ar2 = ar2;
		this.ar3 = ar3;
		this.ar4 = ar4;
		this.ar5 = ar5;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
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

	@Override
	public String toString() {
		return getClass().getSimpleName() + '[' + getType()
		       + ", x=" + getX() / 65536.0
		       + ", y=" + getY() / 65536.0
		       + ", z=" + z / 65536.0
		       + ", a=" + getAngle() * 180.0f / 2147483648.0f
		       + ", fl=" + getFlags()
		       + ", tid=" + tid
		       + ", sp=" + action
		       + ", a1=" + ar1
		       + ", a2=" + ar2
		       + ", a3=" + ar3
		       + ", a4=" + ar4
		       + ", a5=" + ar5
		       + ']';
	}
}
