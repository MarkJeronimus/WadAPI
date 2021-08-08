package org.digitalmodular.wadapi.lump;

import java.util.ArrayList;
import java.util.Iterator;

import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;
import static org.digitalmodular.utilities.ValidatorUtilities.requireStringLengthAtLeast;

import org.digitalmodular.wadapi.LumpType;

/**
 * @param <T> Type of element to store in this list.
 * @author Zom-B
 */
// Created 2021-08-05
public abstract class ListLump<T> extends Lump implements Iterable<T> {
	private final String       elementName;
	private final ArrayList<T> elements;

	protected ListLump(String name, LumpType lumpType, String elementName, int initialCapacity) {
		super(name, lumpType);

		this.elementName = requireStringLengthAtLeast(1, elementName, elementName);
		elements = new ArrayList<>(requireAtLeast(0, initialCapacity, "initialCapacity"));
	}

	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public int size() {
		return elements.size();
	}

	public T get(int index) {
		return elements.get(index);
	}

	public void add(T element) {
		elements.add(requireNonNull(element, elementName));
	}

	public void set(int index, T element) {
		elements.set(index, requireNonNull(element, elementName));
	}

	public void remove(int index) {
		elements.remove(index);
	}

	public void ensureCapacity(int newCapacity) {
		elements.ensureCapacity(newCapacity);
	}

	@Override
	public Iterator<T> iterator() {
		return elements.iterator();
	}
}
