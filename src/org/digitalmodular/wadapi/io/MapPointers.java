package org.digitalmodular.wadapi.io;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

/**
 * @author Zom-B
 */
// Created 2021-08-02
public class MapPointers implements Iterable<LumpPointer> {
	private final           LumpPointer mapTagPointer;
	private final           LumpPointer thingsPointer;
	private final           LumpPointer linedefsPointer;
	private final           LumpPointer sidedefsPointer;
	private final           LumpPointer verticesPointer;
	private final @Nullable LumpPointer segmentsPointer;
	private final @Nullable LumpPointer subsectorsPointer;
	private final @Nullable LumpPointer nodesPointer;
	private final           LumpPointer sectorsPointer;
	private final @Nullable LumpPointer rejectPointer;
	private final @Nullable LumpPointer blockmapPointer;
	private final @Nullable LumpPointer scriptsPointer;
	private final @Nullable LumpPointer behaviorPointer;

	public MapPointers(LumpPointer mapTagPointer,
	                   LumpPointer thingsPointer,
	                   LumpPointer linedefsPointer,
	                   LumpPointer sidedefsPointer,
	                   LumpPointer verticesPointer,
	                   @Nullable LumpPointer segmentsPointer,
	                   @Nullable LumpPointer subsectorsPointer,
	                   @Nullable LumpPointer nodesPointer,
	                   LumpPointer sectorsPointer,
	                   @Nullable LumpPointer rejectPointer,
	                   @Nullable LumpPointer blockmapPointer,
	                   @Nullable LumpPointer scriptsPointer,
	                   @Nullable LumpPointer behaviorPointer) {
		this.mapTagPointer = requireNonNull(mapTagPointer, "mapTagPointer");
		this.thingsPointer = requireNonNull(thingsPointer, "thingsPointer");
		this.linedefsPointer = requireNonNull(linedefsPointer, "linedefsPointer");
		this.sidedefsPointer = requireNonNull(sidedefsPointer, "sidedefsPointer");
		this.verticesPointer = requireNonNull(verticesPointer, "verticesPointer");
		this.segmentsPointer = segmentsPointer;
		this.subsectorsPointer = subsectorsPointer;
		this.nodesPointer = nodesPointer;
		this.sectorsPointer = requireNonNull(sectorsPointer, "sectorsPointer");
		this.rejectPointer = rejectPointer;
		this.blockmapPointer = blockmapPointer;
		this.scriptsPointer = scriptsPointer;
		this.behaviorPointer = behaviorPointer;
	}

	public LumpPointer getMapTagPointer() {
		return mapTagPointer;
	}

	public LumpPointer getThingsPointer() {
		return thingsPointer;
	}

	public LumpPointer getLinedefsPointer() {
		return linedefsPointer;
	}

	public LumpPointer getSidedefsPointer() {
		return sidedefsPointer;
	}

	public LumpPointer getVerticesPointer() {
		return verticesPointer;
	}

	public @Nullable LumpPointer getSegmentsPointer() {
		return segmentsPointer;
	}

	public @Nullable LumpPointer getSubsectorsPointer() {
		return subsectorsPointer;
	}

	public @Nullable LumpPointer getNodesPointer() {
		return nodesPointer;
	}

	public LumpPointer getSectorsPointer() {
		return sectorsPointer;
	}

	public @Nullable LumpPointer getRejectPointer() {
		return rejectPointer;
	}

	public @Nullable LumpPointer getBlockmapPointer() {
		return blockmapPointer;
	}

	public @Nullable LumpPointer getScriptsPointer() {
		return scriptsPointer;
	}

	public @Nullable LumpPointer getBehaviorPointer() {
		return behaviorPointer;
	}

	@Override
	public Iterator<LumpPointer> iterator() {
		Collection<LumpPointer> lumpPointers = new ArrayList<>(13);

		lumpPointers.add(mapTagPointer);
		lumpPointers.add(thingsPointer);
		lumpPointers.add(linedefsPointer);
		lumpPointers.add(sidedefsPointer);
		lumpPointers.add(verticesPointer);

		if (segmentsPointer != null)
			lumpPointers.add(segmentsPointer);

		if (subsectorsPointer != null)
			lumpPointers.add(subsectorsPointer);

		if (nodesPointer != null)
			lumpPointers.add(nodesPointer);

		lumpPointers.add(sectorsPointer);

		if (rejectPointer != null)
			lumpPointers.add(rejectPointer);

		if (blockmapPointer != null)
			lumpPointers.add(blockmapPointer);

		if (scriptsPointer != null)
			lumpPointers.add(scriptsPointer);

		if (behaviorPointer != null)
			lumpPointers.add(behaviorPointer);

		return lumpPointers.iterator();
	}
}
