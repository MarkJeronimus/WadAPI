package wadapi.io;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.digitalmodular.utilities.annotation.UtilityClass;

/**
 * @author Zom-B
 */
// Created 2021-08-02
@UtilityClass
public final class WadIOUtilities {
	private WadIOUtilities() {
		throw new AssertionError();
	}

	public static int calcNumFields(int size, int fieldSize, String name) {
		int numFields = size / fieldSize;

		int extra = size - numFields * fieldSize;
		if (extra != 0)
			Logger.getGlobal().log(Level.WARNING, extra + " extra bytes after data: name = " + name +
			                                      ", size = " + size + ", fieldSize = " + fieldSize);

		return numFields;
	}
}
