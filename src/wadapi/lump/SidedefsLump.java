package wadapi.lump;

import java.util.ArrayList;
import java.util.Iterator;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.LumpType;
import wadapi.structure.Sidedef;
import static wadapi.LumpType.SIDEDEFS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SidedefsLump extends Lump implements Iterable<Sidedef> {
	private final ArrayList<Sidedef> sidedefs;

	public SidedefsLump(String name, int initialCapacity) {
		super(name);

		sidedefs = new ArrayList<>(initialCapacity);
	}

	@Override
	public LumpType getLumpType() {
		return SIDEDEFS;
	}

	public int numSidedefs() {
		return sidedefs.size();
	}

	public Sidedef get(int index) {
		return sidedefs.get(index);
	}

	public void add(Sidedef sidedef) {
		sidedefs.add(requireNonNull(sidedef, "sidedef"));
	}

	public void set(int index, Sidedef sidedef) {
		sidedefs.set(index, requireNonNull(sidedef, "sidedef"));
	}

	public void remove(int index) {
		sidedefs.remove(index);
	}

	public void ensureCapacity(int newCapacity) {
		sidedefs.ensureCapacity(newCapacity);
	}

	@Override
	public Iterator<Sidedef> iterator() {
		return sidedefs.iterator();
	}
}
