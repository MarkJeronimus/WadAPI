package wadapi.io;

import java.util.logging.Logger;
import static java.util.logging.Level.WARNING;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.LumpType;
import wadapi.lump.Lump;

/**
 * @author Zom-B
 */
// Created 2018-01-23
public class MapPointersBuilder {
	private final LumpPointer mapTagPointer;

	private final Lump mapTag;

	private @Nullable LumpPointer thingsPointer     = null; // Mandatory
	private @Nullable LumpPointer linedefsPointer   = null; // Mandatory
	private @Nullable LumpPointer sidedefsPointer   = null; // Mandatory
	private @Nullable LumpPointer verticesPointer   = null; // Mandatory
	private @Nullable LumpPointer segmentsPointer   = null;
	private @Nullable LumpPointer subsectorsPointer = null;
	private @Nullable LumpPointer nodesPointer      = null;
	private @Nullable LumpPointer sectorsPointer    = null; // Mandatory
	private @Nullable LumpPointer rejectPointer     = null;
	private @Nullable LumpPointer blockmapPointer   = null;
	private @Nullable LumpPointer scriptsPointer    = null;
	private @Nullable LumpPointer behaviorPointer   = null;

	public MapPointersBuilder(LumpPointer mapTagPointer) {
		this.mapTagPointer = requireNonNull(mapTagPointer, "mapLumpPointer");

		mapTag = mapTagPointer.getLump();
	}

	public void addMapLump(LumpPointer lumpPointer) {
		requireNonNull(lumpPointer, "lumpPointer");

		Lump lump = lumpPointer.getLump();

		switch (lump.getLumpType()) {
			case THINGS:
				if (thingsPointer != null)
					Logger.getGlobal().log(
							WARNING, "Duplicate " + LumpType.THINGS + " found for map " + mapTag.getName());

				thingsPointer = lumpPointer;
				return;
			case LINEDEFS:
				if (linedefsPointer != null)
					Logger.getGlobal().log(
							WARNING, "Duplicate " + LumpType.LINEDEFS + " found for map " + mapTag.getName());

				linedefsPointer = lumpPointer;
				return;
			case SIDEDEFS:
				if (sidedefsPointer != null)
					Logger.getGlobal().log(
							WARNING, "Duplicate " + LumpType.SIDEDEFS + " found for map " + mapTag.getName());

				sidedefsPointer = lumpPointer;
				return;
			case VERTEXES:
				if (verticesPointer != null)
					Logger.getGlobal().log(
							WARNING, "Duplicate " + LumpType.VERTEXES + " found for map " + mapTag.getName());

				verticesPointer = lumpPointer;
				return;
			case SEGS:
				if (segmentsPointer != null)
					Logger.getGlobal().log(
							WARNING, "Duplicate " + LumpType.SEGS + " found for map " + mapTag.getName());

				segmentsPointer = lumpPointer;
				return;
			case SSECTORS:
				if (subsectorsPointer != null)
					Logger.getGlobal().log(
							WARNING, "Duplicate " + LumpType.SSECTORS + " found for map " + mapTag.getName());

				subsectorsPointer = lumpPointer;
				return;
			case NODES:
				if (nodesPointer != null)
					Logger.getGlobal().log(
							WARNING, "Duplicate " + LumpType.NODES + " found for map " + mapTag.getName());

				nodesPointer = lumpPointer;
				return;
			case SECTORS:
				if (sectorsPointer != null)
					Logger.getGlobal().log(
							WARNING, "Duplicate " + LumpType.SECTORS + " found for map " + mapTag.getName());

				sectorsPointer = lumpPointer;
				return;
			case REJECT:
				if (rejectPointer != null)
					Logger.getGlobal().log(
							WARNING, "Duplicate " + LumpType.REJECT + " found for map " + mapTag.getName());

				rejectPointer = lumpPointer;
				return;
			case BLOCKMAP:
				if (blockmapPointer != null)
					Logger.getGlobal().log(
							WARNING, "Duplicate " + LumpType.BLOCKMAP + " found for map " + mapTag.getName());

				blockmapPointer = lumpPointer;
				return;
			case SCRIPTS:
				if (scriptsPointer != null)
					Logger.getGlobal().log(
							WARNING, "Duplicate " + LumpType.SCRIPTS + " found for map " + mapTag.getName());

				scriptsPointer = lumpPointer;
				return;
			case BEHAVIOR:
				if (behaviorPointer != null)
					Logger.getGlobal().log(
							WARNING, "Duplicate " + LumpType.BEHAVIOR + " found for map " + mapTag.getName());

				behaviorPointer = lumpPointer;
				return;
			default:
				throw new IllegalArgumentException("Not a map lump: " + lump.getName());
		}
	}

	public @Nullable MapPointers build() {
		if (thingsPointer == null) {
			Logger.getGlobal().log(WARNING, LumpType.THINGS + " not found for map " + mapTag.getName());
			return null;
		} else if (linedefsPointer == null) {
			Logger.getGlobal().log(WARNING, LumpType.LINEDEFS + " not found for map " + mapTag.getName());
			return null;
		} else if (sidedefsPointer == null) {
			Logger.getGlobal().log(WARNING, LumpType.SIDEDEFS + " not found for map " + mapTag.getName());
			return null;
		} else if (verticesPointer == null) {
			Logger.getGlobal().log(WARNING, LumpType.VERTEXES + " not found for map " + mapTag.getName());
			return null;
		} else if (sectorsPointer == null) {
			Logger.getGlobal().log(WARNING, LumpType.SECTORS + " not found for map " + mapTag.getName());
			return null;
		}

		return new MapPointers(mapTagPointer,
		                       thingsPointer,
		                       linedefsPointer,
		                       sidedefsPointer,
		                       verticesPointer,
		                       segmentsPointer,
		                       subsectorsPointer,
		                       nodesPointer,
		                       sectorsPointer,
		                       rejectPointer,
		                       blockmapPointer,
		                       scriptsPointer,
		                       behaviorPointer);
	}
}
