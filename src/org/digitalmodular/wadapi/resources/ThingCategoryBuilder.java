package org.digitalmodular.wadapi.resources;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

/**
 * @author Zom-B
 */
// Created 2021-08-18
public class ThingCategoryBuilder {
	private @Nullable String  title;
	private           boolean sorted = false;

	public String getTitle() {
		if (title == null)
			throw new IllegalStateException("'title' not set yet");

		return title;
	}

	public void setTitle(String title) {
		this.title = requireNonNull(title, "title");
	}

	public boolean isSorted() {
		return sorted;
	}

	public void setSorted(boolean sorted) {
		this.sorted = sorted;
	}

	public void setSorted(int sort) {
		sorted = sort != 0;
	}
}
