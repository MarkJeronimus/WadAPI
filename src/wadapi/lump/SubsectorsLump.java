package wadapi.lump;

import java.util.ArrayList;
import java.util.Iterator;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.structure.Subsector;
import static wadapi.LumpType.SSECTORS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SubsectorsLump extends Lump implements Iterable<Subsector> {
	private final ArrayList<Subsector> subsectors;

	public SubsectorsLump(String name, int initialCapacity) {
		super(name, SSECTORS);

		subsectors = new ArrayList<>(initialCapacity);
	}

	public int numVertices() {
		return subsectors.size();
	}

	public Subsector get(int index) {
		return subsectors.get(index);
	}

	public void add(Subsector subsector) {
		subsectors.add(requireNonNull(subsector, "subsector"));
	}

	public void set(int index, Subsector subsector) {
		subsectors.set(index, requireNonNull(subsector, "subsector"));
	}

	public void remove(int index) {
		subsectors.remove(index);
	}

	public void ensureCapacity(int newCapacity) {
		subsectors.ensureCapacity(newCapacity);
	}

	@Override
	public Iterator<Subsector> iterator() {
		return subsectors.iterator();
	}
}
