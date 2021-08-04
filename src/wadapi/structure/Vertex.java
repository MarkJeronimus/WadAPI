package wadapi.structure;

/**
 * @author Zom-B
 */
// Created 2011-08-14
public class Vertex implements Comparable<Vertex> {
	private int x;
	private int y;

	public Vertex(int x, int y) {
		this.x = x;
		this.y = y;
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

	public boolean equals(Vertex other) {
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + ']';
	}

	@Override
	public int compareTo(Vertex o) {
		if (y != o.y)
			return y > o.y ? 1 : -1;
		if (x != o.x)
			return x > o.x ? 1 : -1;
		return 0;
	}
}
