package org.digitalmodular.wadapi.structure;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class Palette {
	private final int[] palette;

	public Palette() {
		palette = new int[256];
	}

	public int get(int index) {
		return palette[index];
	}

	public void set(int index, int value) {
		palette[index] = value;
	}
}
