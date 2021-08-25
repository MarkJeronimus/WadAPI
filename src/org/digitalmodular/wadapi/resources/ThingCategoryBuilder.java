package org.digitalmodular.wadapi.resources;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;
import static org.digitalmodular.utilities.ValidatorUtilities.requireStringLengthAtLeast;

/**
 * @author Zom-B
 */
// Created 2021-08-18
class ThingCategoryBuilder implements ThingCategory {
	private final String name;

	private @Nullable String  title;
	private           boolean sorted = false;

	ThingCategoryBuilder(String name) {
		this.name = requireStringLengthAtLeast(1, name, "name");
	}

	public String getName() {
		return name;
	}

	@Override
	public String getTitle() {
		if (title == null)
			throw new IllegalStateException("'title' not set yet");

		return title;
	}

	public void setTitle(String title) {
		this.title = requireNonNull(title, "title");
	}

	@Override
	public boolean isSorted() {
		return sorted;
	}

	public void setSorted(int sort) {
		sorted = sort != 0;
	}
}
