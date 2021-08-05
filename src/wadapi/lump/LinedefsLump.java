package wadapi.lump;

import java.util.ArrayList;
import java.util.Iterator;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.structure.Linedef;
import static wadapi.LumpType.LINEDEFS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class LinedefsLump extends Lump implements Iterable<Linedef> {
	private final ArrayList<Linedef> linedefs;

	public LinedefsLump(String name, int initialCapacity) {
		super(name, LINEDEFS);

		linedefs = new ArrayList<>(initialCapacity);
	}

	public int numLinedefs() {
		return linedefs.size();
	}

	public Linedef get(int index) {
		return linedefs.get(index);
	}

	public void add(Linedef linedef) {
		linedefs.add(requireNonNull(linedef, "linedef"));
	}

	public void set(int index, Linedef linedef) {
		linedefs.set(index, requireNonNull(linedef, "linedef"));
	}

	public void remove(int index) {
		linedefs.remove(index);
	}

	public void ensureCapacity(int newCapacity) {
		linedefs.ensureCapacity(newCapacity);
	}

	@Override
	public Iterator<Linedef> iterator() {
		return linedefs.iterator();
	}
}
