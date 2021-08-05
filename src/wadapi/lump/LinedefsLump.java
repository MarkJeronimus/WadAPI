package wadapi.lump;

import java.util.ArrayList;
import java.util.List;

import wadapi.structure.Linedef;
import static wadapi.LumpType.LINEDEFS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class LinedefsLump extends Lump {
	private final List<Linedef> linedefs;

	public LinedefsLump(String name, int initialCapacity) {
		super(name, LINEDEFS);

		linedefs = new ArrayList<>(initialCapacity);
	}

	public List<Linedef> getLinedefs() {
		return linedefs;
	}
}
