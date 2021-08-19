package org.digitalmodular.wadapi.resources;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

/**
 * @author Zom-B
 */
// Created 2021-08-18
public class ThingCategoryBuilder {
	private @Nullable String  name;
	private @Nullable String  title;
	private           boolean sorted = false;

	public void setName(String name) {
		this.name = requireNonNull(name, "name");
	}

	public void setTitle(String title) {
		this.title = requireNonNull(title, "title");
	}

	public void setSorted(int sort) {
		sorted = sort != 0;
	}
}
