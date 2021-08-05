package wadapi.lump;

import java.util.ArrayList;
import java.util.Iterator;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.structure.Segment;
import static wadapi.LumpType.SEGS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SegmentsLump extends Lump implements Iterable<Segment> {
	private final ArrayList<Segment> segments;

	public SegmentsLump(String name, int initialCapacity) {
		super(name, SEGS);

		segments = new ArrayList<>(initialCapacity);
	}

	public int numSegments() {
		return segments.size();
	}

	public Segment get(int index) {
		return segments.get(index);
	}

	public void add(Segment segment) {
		segments.add(requireNonNull(segment, "segment"));
	}

	public void set(int index, Segment segment) {
		segments.set(index, requireNonNull(segment, "segment"));
	}

	public void remove(int index) {
		segments.remove(index);
	}

	public void ensureCapacity(int newCapacity) {
		segments.ensureCapacity(newCapacity);
	}

	@Override
	public Iterator<Segment> iterator() {
		return segments.iterator();
	}
}
