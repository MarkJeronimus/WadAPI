package wadapi.io;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.LumpUtilities;
import wadapi.WadMap;
import wadapi.lump.BinaryLump;
import wadapi.lump.LinedefsLump;
import wadapi.lump.Lump;
import wadapi.lump.NodesLump;
import wadapi.lump.SectorsLump;
import wadapi.lump.SegmentsLump;
import wadapi.lump.SidedefsLump;
import wadapi.lump.SubsectorsLump;
import wadapi.lump.TextLump;
import wadapi.lump.ThingsLump;
import wadapi.lump.VerticesLump;

/**
 * @author Zom-B
 */
// Created 2021-08-02
public class MapPointers {
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

	@SuppressWarnings("OverlyCoupledMethod")
	public WadMap decodeMap() {
		decodeLumps();

		Lump                     mapLump        = getLump(mapTagPointer);
		ThingsLump               thingsLump     = (ThingsLump)getLump(thingsPointer);
		LinedefsLump             linedefsLump   = (LinedefsLump)getLump(linedefsPointer);
		SidedefsLump             sidedefsLump   = (SidedefsLump)getLump(sidedefsPointer);
		VerticesLump             verticesLump   = (VerticesLump)getLump(verticesPointer);
		@Nullable SegmentsLump   segmentsLump   = (SegmentsLump)getLump(segmentsPointer);
		@Nullable SubsectorsLump subsectorsLump = (SubsectorsLump)getLump(subsectorsPointer);
		@Nullable NodesLump      nodesLump      = (NodesLump)getLump(nodesPointer);
		SectorsLump              sectorsLump    = (SectorsLump)getLump(sectorsPointer);
		@Nullable BinaryLump     rejectLump     = (BinaryLump)getLump(rejectPointer);
		@Nullable BinaryLump     blockmapLump   = (BinaryLump)getLump(blockmapPointer);
		@Nullable TextLump       scriptsLump    = (TextLump)getLump(scriptsPointer);
		@Nullable BinaryLump     behaviorLump   = (BinaryLump)getLump(behaviorPointer);

		return new WadMap(mapLump,
		                  thingsLump,
		                  linedefsLump,
		                  sidedefsLump,
		                  verticesLump,
		                  segmentsLump,
		                  subsectorsLump,
		                  nodesLump,
		                  sectorsLump,
		                  rejectLump,
		                  blockmapLump,
		                  scriptsLump,
		                  behaviorLump);
	}

	private void decodeLumps() {
		decodeLump(mapTagPointer);
		decodeLump(thingsPointer);
		decodeLump(linedefsPointer);
		decodeLump(sidedefsPointer);
		decodeLump(verticesPointer);
		decodeLump(segmentsPointer);
		decodeLump(subsectorsPointer);
		decodeLump(nodesPointer);
		decodeLump(sectorsPointer);
		decodeLump(rejectPointer);
		decodeLump(blockmapPointer);
		decodeLump(scriptsPointer);
		decodeLump(behaviorPointer);
	}

	private static void decodeLump(@Nullable LumpPointer lumpPointer) {
		if (lumpPointer == null)
			return;

		Lump decodedLump = LumpUtilities.decodeLump(lumpPointer.getLump());
		lumpPointer.setLump(decodedLump);
	}

	@Contract("null -> null; !null -> !null")
	private static @Nullable Lump getLump(@Nullable LumpPointer pointer) {
		return pointer == null ? null : pointer.getLump();
	}
}
