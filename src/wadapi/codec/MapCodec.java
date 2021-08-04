package wadapi.codec;

import org.jetbrains.annotations.Nullable;

import org.digitalmodular.utilities.annotation.UtilityClass;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.LumpUtilities;
import wadapi.WadMap;
import wadapi.io.LumpPointer;
import wadapi.io.MapPointers;
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
@UtilityClass
public final class MapCodec {
	private MapCodec() {
		throw new AssertionError();
	}

	public static WadMap makeMap(MapPointers mapPointers) {
		requireNonNull(mapPointers, "mapPointers");

		for (LumpPointer mapPointer : mapPointers)
			decodeLump(mapPointer);

		return decodeMap(mapPointers);
	}

	private static void decodeLump(@Nullable LumpPointer lumpPointer) {
		if (lumpPointer == null)
			return;

		Lump decodedLump = LumpUtilities.decodeLump(lumpPointer.getLump());
		lumpPointer.setLump(decodedLump);
	}

	@SuppressWarnings("OverlyCoupledMethod")
	private static WadMap decodeMap(MapPointers mapPointers) {
		Lump mapLump =
				mapPointers.getMapTagPointer().getLump();
		ThingsLump thingsLump =
				(ThingsLump)mapPointers.getThingsPointer().getLump();
		LinedefsLump linedefsLump =
				(LinedefsLump)mapPointers.getLinedefsPointer().getLump();
		SidedefsLump sidedefsLump =
				(SidedefsLump)mapPointers.getSidedefsPointer().getLump();
		VerticesLump verticesLump =
				(VerticesLump)mapPointers.getVerticesPointer().getLump();
		@Nullable SegmentsLump segmentsLump =
				(SegmentsLump)LumpPointer.getNullableLump(mapPointers.getSegmentsPointer());
		@Nullable SubsectorsLump subsectorsLump =
				(SubsectorsLump)LumpPointer.getNullableLump(mapPointers.getSubsectorsPointer());
		@Nullable NodesLump nodesLump =
				(NodesLump)LumpPointer.getNullableLump(mapPointers.getNodesPointer());
		SectorsLump sectorsLump =
				(SectorsLump)mapPointers.getSectorsPointer().getLump();
		@Nullable BinaryLump rejectLump =
				(BinaryLump)LumpPointer.getNullableLump(mapPointers.getRejectPointer());
		@Nullable BinaryLump blockmapLump =
				(BinaryLump)LumpPointer.getNullableLump(mapPointers.getBlockmapPointer());
		@Nullable TextLump scriptsLump =
				(TextLump)LumpPointer.getNullableLump(mapPointers.getScriptsPointer());
		@Nullable BinaryLump behaviorLump =
				(BinaryLump)LumpPointer.getNullableLump(mapPointers.getBehaviorPointer());

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

}
