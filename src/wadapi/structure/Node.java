package wadapi.structure;

/**
 * @author Zom-B
 */
// Created 2011-08-15
public class Node {
	private int x;
	private int y;
	private int dx;
	private int dy;

	// Bounding box for each child,
	private int bbox0y2;
	private int bbox0y1;
	private int bbox0x1;
	private int bbox0x2;
	private int bbox1y2;
	private int bbox1y1;
	private int bbox1x1;
	private int bbox1x2;

	private int childNode0;
	private int childNode1;
	private int subsector0;
	private int subsector1;

	public Node(int x,
	            int y,
	            int dx,
	            int dy,
	            int bbox0y2,
	            int bbox0y1,
	            int bbox0x1,
	            int bbox0x2,
	            int bbox1y2,
	            int bbox1y1,
	            int bbox1x1,
	            int bbox1x2,
	            int childNode0,
	            int childNode1,
	            int subsector0,
	            int subsector1) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.bbox0y2 = bbox0y2;
		this.bbox0y1 = bbox0y1;
		this.bbox0x1 = bbox0x1;
		this.bbox0x2 = bbox0x2;
		this.bbox1y2 = bbox1y2;
		this.bbox1y1 = bbox1y1;
		this.bbox1x1 = bbox1x1;
		this.bbox1x2 = bbox1x2;
		this.childNode0 = childNode0;
		this.childNode1 = childNode1;
		this.subsector0 = subsector0;
		this.subsector1 = subsector1;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDX() {
		return dx;
	}

	public int getDY() {
		return dy;
	}

	public int getBbox0y2() {
		return bbox0y2;
	}

	public int getBbox0y1() {
		return bbox0y1;
	}

	public int getBbox0x1() {
		return bbox0x1;
	}

	public int getBbox0x2() {
		return bbox0x2;
	}

	public int getBbox1y2() {
		return bbox1y2;
	}

	public int getBbox1y1() {
		return bbox1y1;
	}

	public int getBbox1x1() {
		return bbox1x1;
	}

	public int getBbox1x2() {
		return bbox1x2;
	}

	public int getChildNode0() {
		return childNode0;
	}

	public int getChildNode1() {
		return childNode1;
	}

	public int getSubsector0() {
		return subsector0;
	}

	public int getSubsector1() {
		return subsector1;
	}

	@Override
	public String toString() {
		return "Node{" +
		       "x=" + x / 65536.0 +
		       ", y=" + y / 65536.0 +
		       ", dx=" + dx / 65536.0 +
		       ", dy=" + dy / 65536.0 +
		       ", bboxR=[" + bbox0x1 / 65536.0 +
		       ", " + bbox0x2 / 65536.0 +
		       ", " + bbox0y1 / 65536.0 +
		       ", " + bbox0y2 / 65536.0 +
		       "], bboxL=[" + bbox1x1 / 65536.0 +
		       ", " + bbox1x2 / 65536.0 +
		       ", " + bbox1y1 / 65536.0 +
		       ", " + bbox1y2 / 65536.0 +
		       "], childR=" + (childNode0 != 0 ? ("node " + childNode0) : ("subsector " + subsector0)) +
		       ", childL=" + (childNode1 != 0 ? ("node " + childNode1) : ("subsector " + subsector1)) +
		       '}';
	}
}
