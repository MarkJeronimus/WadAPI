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
	// clip against view frustum.
	private int bbox0y2;
	private int bbox0y1;
	private int bbox0x1;
	private int bbox0x2;
	private int bbox1y2;
	private int bbox1y1;
	private int bbox1x1;
	private int bbox1x2;

	// If NF_SUBSECTOR its a subsector,
	// else it's a node of another subtree.
	private int child0;
	private int child1;

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
	            int child0,
	            int child1) {
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
		this.child0 = child0;
		this.child1 = child1;
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

	public int getChild0() {
		return child0;
	}

	public int getChild1() {
		return child1;
	}

	@Override
	public String toString() {
		return "Node{" +
		       "x=" + x +
		       ", y=" + y +
		       ", dx=" + dx +
		       ", dy=" +    dy +
		       ", bboxR=[" + bbox0y2 +
		       ", " + bbox0y1+
		       ", " + bbox0x1 +
		       ", " + bbox0x2  +
		       "], bboxL=[" + bbox1y2 +
		       ", " + bbox1y1 +
		       ", " + bbox1x1 +
		       ", " + bbox1x2 +
		       "], childR=" + ((child0 & 0x8000) != 0 ? "subsector " : "node ") + (child0 & 0x7FFF) +
		       ", childL=" + ((child1 & 0x8000) != 0 ? "subsector " : "node ") + (child1 & 0x7FFF) +
		       '}';
	}
}
