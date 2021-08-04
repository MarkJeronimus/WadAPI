package wadapi.codec;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.WadMap;
import wadapi.io.MapPointers;

/**
 * @author Zom-B
 */
// Created 2021-08-02
public class MapCodec {
	public static @Nullable WadMap makeMap(MapPointers mapPointers) {\
		requireNonNull(mapPointers, "mapPointers");
		return mapPointers.decodeMap();
	}
}
