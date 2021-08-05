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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (!(o instanceof Vertex))
			return false;

		Vertex other = (Vertex)o;
		return Float.floatToIntBits(getX()) == Float.floatToIntBits(other.getX()) &&
		       Float.floatToIntBits(getY()) == Float.floatToIntBits(other.getY());
	}

	@Override
	public int hashCode() {
		int hashCode = 0x811C9DC5;
		hashCode = 0x01000193 * (hashCode ^ Float.hashCode(getX()));
		hashCode = 0x01000193 * (hashCode ^ Float.hashCode(getY()));
		return hashCode;
	}

	@Override
	public int compareTo(Vertex o) {
		int i = Float.compare(x, o.x);
		if (i != 0)
			return i;

		return Float.compare(y, o.y);
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + ']';
	}
}
