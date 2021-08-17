package org.digitalmodular.wadapi;

import org.digitalmodular.utilities.ValidatorUtilities;

/**
 * @author zom-b
 */
// Created 2021-08-16
public enum SourcePort {
	BOOM("Boom"),
	DOOM("Doom"),
	ETERNITY("Eternity"),
	GZDOOM("GZDoom"),
	HERETIC("Heretic"),
	HEXEN("Hexen"),
	MBF21("MBF21"),
	STRIFE("Strife"),
	ZANDRONUM("Zandronum"),
	ZDAEMON("Zdaemon"),
	ZDOOM("Zdoom");

	private final String name;

	SourcePort(String name) {
		this.name = ValidatorUtilities.requireStringLengthAtLeast(1, name, "name");
	}

	public String getName() {
		return name;
	}
}
