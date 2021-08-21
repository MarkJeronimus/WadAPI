package org.digitalmodular.wadapi;

import java.awt.Color;

import org.digitalmodular.utilities.annotation.ConstClass;

/**
 * @author Zom-B
 */
// Created 2021-08-21
@ConstClass
public final class ColorConstants {
	private ColorConstants() {
		throw new AssertionError();
	}

	private static final Color[] THING_COLORS = {new Color(0x696969),
	                                             new Color(0x4169E1),
	                                             new Color(0x228B22),
	                                             new Color(0x20B2AA),
	                                             new Color(0xB22222),
	                                             new Color(0x9400D3),
	                                             new Color(0xB8860B),
	                                             new Color(0xC0C0C0),
	                                             new Color(0x708090),
	                                             new Color(0x00BFFF),
	                                             new Color(0x32CD32),
	                                             new Color(0xAFEEEE),
	                                             new Color(0xFF6347),
	                                             new Color(0xEE82EE),
	                                             new Color(0xFFFF00),
	                                             new Color(0xF5F5F5),
	                                             new Color(0xFFB6C1),
	                                             new Color(0xFF8C00),
	                                             new Color(0xBDB76B),
	                                             new Color(0xDAA520)};

	public static Color getThingColor(int index) {
		if (index < 1 || index >= THING_COLORS.length)
			return THING_COLORS[0];

		return THING_COLORS[index];
	}
}
