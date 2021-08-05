package wadapi.lump;

import java.util.ArrayList;
import java.util.Iterator;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.LumpType;
import wadapi.structure.Thing;
import static wadapi.LumpType.THINGS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class ThingsLump extends Lump implements Iterable<Thing> {
	private final ArrayList<Thing> things;

	public ThingsLump(String name, int initialCapacity) {
		super(name);

		things = new ArrayList<>(initialCapacity);
	}

	@Override
	public LumpType getLumpType() {
		return THINGS;
	}

	public int numThings() {
		return things.size();
	}

	public Thing get(int index) {
		return things.get(index);
	}

	public void add(Thing thing) {
		things.add(requireNonNull(thing, "thing"));
	}

	public void set(int index, Thing thing) {
		things.set(index, requireNonNull(thing, "thing"));
	}

	public void remove(int index) {
		things.remove(index);
	}

	public void ensureCapacity(int newCapacity) {
		things.ensureCapacity(newCapacity);
	}

	@Override
	public Iterator<Thing> iterator() {
		return things.iterator();
	}
}
