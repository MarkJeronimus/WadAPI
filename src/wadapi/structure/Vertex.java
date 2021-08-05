package wadapi.structure;

/**
 * A coordinate in Doom's "FIXED" 16.16 format, but since Java doesn't support Fixed,\
 * it's a raw 32-bit int where each step of 0x10000 represents a map unit.
 *
 * @author Zom-B
 */
// Created 2011-08-14
public class Vertex implements Comparable<Vertex> {
	private final int x;
	private final int y;

	public static Vertex fromMapUnits(int x, int y) {
		return new Vertex(x << 16, y << 16);
	}

	public static Vertex fromFixed(int x, int y) {
		return new Vertex(x, y);
	}

	private Vertex(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns the x coordinate at full precision, as an int.
	 */
	public int getFixedX() {
		return x;
	}

	/**
	 * Returns the x coordinate at full precision, as a float.
	 * <p>
	 * This getter has slightly less performance than {@link #getFixedY()} because of the scaling calculation.
	 */
	public float getFloatX() {
		return x / 65536.0f;
	}

	/**
	 * Returns the x coordinate rounded to the nearest map unit.
	 * <p>
	 * This getter has slightly less performance than {@link #getFixedX()} because of the rounding calculation.
	 */
	public int getMapUnitX() {
		return (x + 32768) >> 16;
	}

	/**
	 * Returns the y coordinate at full precision, as an int.
	 */
	public int getFixedY() {
		return y;
	}

	/**
	 * Returns the y coordinate at full precision, as a float.
	 * <p>
	 * This getter has slightly less performance than {@link #getFixedY()} because of the scaling calculation.
	 */
	public float getFloatY() {
		return y / 65536.0f;
	}

	/**
	 * Returns the Y coordinate rounded to the nearest map unit.
	 * <p>
	 * This getter has slightly less performance than {@link #getFixedY()} because of the rounding calculation.
	 */
	public int getMapUnitY() {
		return (y + 32768) >> 16;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (!(o instanceof Vertex))
			return false;

		Vertex other = (Vertex)o;
		return Float.floatToIntBits(x) == Float.floatToIntBits(other.x) &&
		       Float.floatToIntBits(y) == Float.floatToIntBits(other.y);
	}

	@Override
	public int hashCode() {
		int hashCode = 0x811C9DC5;
		hashCode = 0x01000193 * (hashCode ^ Float.hashCode(x));
		hashCode = 0x01000193 * (hashCode ^ Float.hashCode(y));
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
