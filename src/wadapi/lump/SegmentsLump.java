package wadapi.lump;

import wadapi.structure.Segment;
import static wadapi.LumpType.SEGS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SegmentsLump extends ListLump<Segment> {
	public SegmentsLump(String name, int initialCapacity) {
		super(name, SEGS, "segment", initialCapacity);
	}
}
