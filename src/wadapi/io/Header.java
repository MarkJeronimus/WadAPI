package wadapi.io;

import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;
import static org.digitalmodular.utilities.ValidatorUtilities.requireStringLengthBetween;

/**
 * @author Zom-B
 */
// Created 2017-09-16
public class Header {
	private final String identification;
	private final int    numLumps;
	private final int    infoTableOffset;

	public Header(String identification, int numLumps, int infoTableOffset) {
		this.identification = requireStringLengthBetween(4, 4, identification, "identification");
		this.numLumps = requireAtLeast(0, numLumps, "numLumps");
		this.infoTableOffset = requireAtLeast(HeaderIO.HEADER_SIZE, infoTableOffset, "infoTableOffset");
	}

	public String getIdentification() {
		return identification;
	}

	public int getNumLumps() {
		return numLumps;
	}

	public int getInfoTableOffset() {
		return infoTableOffset;
	}
}
