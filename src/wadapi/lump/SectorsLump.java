package wadapi.lump;

import java.util.ArrayList;
import java.util.Iterator;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.structure.Sector;
import static wadapi.LumpType.SECTORS;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class SectorsLump extends Lump implements Iterable<Sector> {
	private final ArrayList<Sector> sectors;

	public SectorsLump(String name, int initialCapacity) {
		super(name, SECTORS);

		sectors = new ArrayList<>(initialCapacity);
	}

	public int numSectors() {
		return sectors.size();
	}

	public Sector get(int index) {
		return sectors.get(index);
	}

	public void add(Sector sector) {
		sectors.add(requireNonNull(sector, "sector"));
	}

	public void set(int index, Sector sector) {
		sectors.set(index, requireNonNull(sector, "sector"));
	}

	public void remove(int index) {
		sectors.remove(index);
	}

	public void ensureCapacity(int newCapacity) {
		sectors.ensureCapacity(newCapacity);
	}

	@Override
	public Iterator<Sector> iterator() {
		return sectors.iterator();
	}
}
