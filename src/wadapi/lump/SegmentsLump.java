package wadapi.lump;

import java.util.ArrayList;
import java.util.List;

import wadapi.structure.Segment;
import static wadapi.LumpType.SEGS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SegmentsLump extends Lump {
	private final List<Segment> segments;

	public SegmentsLump(String name, int initialCapacity) {
		super(name, SEGS);

		segments = new ArrayList<>(initialCapacity);
	}

	public List<Segment> getSegments() {
		return segments;
	}
}
