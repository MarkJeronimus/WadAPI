package wadapi.structure;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

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

	private @Nullable Node      childNode0;
	private @Nullable Node      childNode1;
	private @Nullable Subsector subsector0;
	private @Nullable Subsector subsector1;

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
	            Object child0,
	            Object child1) {
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
		requireNonNull(child0, "child0");
		requireNonNull(child1, "child1");
		childNode0 = child0 instanceof Node ? (Node)child0 : null;
		childNode1 = child1 instanceof Node ? (Node)child1 : null;
		subsector0 = child0 instanceof Subsector ? (Subsector)child0 : null;
		subsector1 = child1 instanceof Subsector ? (Subsector)child1 : null;
		if (childNode0 == null && subsector0 == null)
			throw new IllegalArgumentException("'child0' must be of type Subsector or Node: " + child0.getClass());
		if (childNode1 == null && subsector1 == null)
			throw new IllegalArgumentException("'child1' must be of type Subsector or Node: " + child1.getClass());
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

	public @Nullable Node getChildNode0() {
		return childNode0;
	}

	public @Nullable Node getChildNode1() {
		return childNode1;
	}

	public @Nullable Subsector getSubsector0() {
		return subsector0;
	}

	public @Nullable Subsector getSubsector1() {
		return subsector1;
	}

	@Override
	public String toString() {
		return "Node{" +
		       "x=" + x +
		       ", y=" + y +
		       ", dx=" + dx +
		       ", dy=" + dy +
		       ", bboxR=[" + bbox0x1 +
		       ", " + bbox0x2 +
		       ", " + bbox0y1 +
		       ", " + bbox0y2 +
		       "], bboxL=[" + bbox1x1 +
		       ", " + bbox1x2 +
		       ", " + bbox1y1 +
		       ", " + bbox1y2 +
		       "], childR=" + (childNode0 != null ? "node" : "subsector") +
		       ", childL=" + (childNode1 != null ? "node" : "subsector") +
		       '}';
	}
}
