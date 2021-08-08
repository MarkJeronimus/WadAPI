package org.digitalmodular.wadapi.codec;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;
import static org.digitalmodular.utilities.ValidatorUtilities.requireOneOf;
import static org.digitalmodular.utilities.ValidatorUtilities.requireType;

import org.digitalmodular.wadapi.WadMap;
import org.digitalmodular.wadapi.lump.BinaryLump;
import org.digitalmodular.wadapi.lump.LinedefsLump;
import org.digitalmodular.wadapi.lump.Lump;
import org.digitalmodular.wadapi.lump.MarkerLump;
import org.digitalmodular.wadapi.lump.NodesLump;
import org.digitalmodular.wadapi.lump.SectorsLump;
import org.digitalmodular.wadapi.lump.SegmentsLump;
import org.digitalmodular.wadapi.lump.SidedefsLump;
import org.digitalmodular.wadapi.lump.SubsectorsLump;
import org.digitalmodular.wadapi.lump.TextLump;
import org.digitalmodular.wadapi.lump.ThingsLump;
import org.digitalmodular.wadapi.lump.VerticesLump;

/**
 * @author Zom-B
 */
// Created 2018-01-23
public class WadMapBuilder {
	private static final Class<?>[] POSSIBLE_MAP_LUMP_CLASSES = {MarkerLump.class,
	                                                             TextLump.class,
	                                                             BinaryLump.class};

	private @Nullable Lump           mapLump        = null;
	private @Nullable ThingsLump     thingsLump     = null;
	private @Nullable LinedefsLump   linedefsLump   = null;
	private @Nullable SidedefsLump   sidedefsLump   = null;
	private @Nullable VerticesLump   verticesLump   = null;
	private @Nullable SegmentsLump   segmentsLump   = null;
	private @Nullable SubsectorsLump subsectorsLump = null;
	private @Nullable NodesLump      nodesLump      = null;
	private @Nullable SectorsLump    sectorsLump    = null;
	private @Nullable BinaryLump     rejectLump     = null;
	private @Nullable BinaryLump     blockmapLump   = null;
	private @Nullable TextLump       scriptsLump    = null;
	private @Nullable BinaryLump     behaviorLump   = null;

	@Nullable
	public Lump getMapLump() {
		return mapLump;
	}

	public void setMapLump(Lump mapLump) {
		requireNonNull(mapLump, "mapLump");
		requireOneOf(POSSIBLE_MAP_LUMP_CLASSES, mapLump.getClass(), "mapLump");
		this.mapLump = requireNonNull(mapLump, "mapLump");
	}

	public @Nullable ThingsLump getThingsLump() {
		return thingsLump;
	}

	public void setThingsLump(Lump thingsLump) {
		this.thingsLump = (ThingsLump)requireType(ThingsLump.class, thingsLump, "thingsLump");
	}

	public @Nullable LinedefsLump getLinedefsLump() {
		return linedefsLump;
	}

	public void setLinedefsLump(Lump linedefsLump) {
		this.linedefsLump = (LinedefsLump)requireType(LinedefsLump.class, linedefsLump, "linedefsLump");
	}

	public @Nullable SidedefsLump getSidedefsLump() {
		return sidedefsLump;
	}

	public void setSidedefsLump(Lump sidedefsLump) {
		this.sidedefsLump = (SidedefsLump)requireType(SidedefsLump.class, sidedefsLump, "sidedefsLump");
	}

	public @Nullable VerticesLump getVerticesLump() {
		return verticesLump;
	}

	public void setVerticesLump(Lump verticesLump) {
		this.verticesLump = (VerticesLump)requireType(VerticesLump.class, verticesLump, "verticesLump");
	}

	public @Nullable SegmentsLump getSegmentsLump() {
		return segmentsLump;
	}

	public void setSegmentsLump(@Nullable Lump segmentsLump) {
		if (segmentsLump != null)
			this.segmentsLump = (SegmentsLump)requireType(SegmentsLump.class, segmentsLump, "segmentsLump");
	}

	public @Nullable SubsectorsLump getSubsectorsLump() {
		return subsectorsLump;
	}

	public void setSubsectorsLump(@Nullable Lump subsectorsLump) {
		if (subsectorsLump != null)
			this.subsectorsLump = (SubsectorsLump)requireType(SubsectorsLump.class, subsectorsLump, "subsectorsLump");
	}

	public @Nullable NodesLump getNodesLump() {
		return nodesLump;
	}

	public void setNodesLump(@Nullable Lump nodesLump) {
		if (nodesLump != null)
			this.nodesLump = (NodesLump)requireType(NodesLump.class, nodesLump, "nodesLump");
	}

	public @Nullable SectorsLump getSectorsLump() {
		return sectorsLump;
	}

	public void setSectorsLump(Lump sectorsLump) {
		this.sectorsLump = (SectorsLump)requireType(SectorsLump.class, sectorsLump, "sectorsLump");
	}

	public @Nullable BinaryLump getRejectLump() {
		return rejectLump;
	}

	public void setRejectLump(@Nullable Lump rejectLump) {
		if (rejectLump != null)
			this.rejectLump = (BinaryLump)requireType(BinaryLump.class, rejectLump, "rejectLump");
	}

	public @Nullable BinaryLump getBlockmapLump() {
		return blockmapLump;
	}

	public void setBlockmapLump(@Nullable Lump blockmapLump) {
		if (blockmapLump != null)
			this.blockmapLump = (BinaryLump)requireType(BinaryLump.class, blockmapLump, "blockmapLump");
	}

	public @Nullable TextLump getScriptsLump() {
		return scriptsLump;
	}

	public void setScriptsLump(@Nullable Lump scriptsLump) {
		if (scriptsLump != null)
			this.scriptsLump = (TextLump)requireType(TextLump.class, scriptsLump, "scriptsLump");
	}

	public @Nullable BinaryLump getBehaviorLump() {
		return behaviorLump;
	}

	public void setBehaviorLump(@Nullable Lump behaviorLump) {
		if (behaviorLump != null)
			this.behaviorLump = (BinaryLump)requireType(BinaryLump.class, behaviorLump, "behaviorLump");
	}

	public WadMap build() {
		if (mapLump == null)
			throw new IllegalStateException("mapLump not set yet");
		if (thingsLump == null)
			throw new IllegalStateException("thingsLump not set yet");
		if (linedefsLump == null)
			throw new IllegalStateException("linedefsLump not set yet");
		if (sidedefsLump == null)
			throw new IllegalStateException("sidedefsLump not set yet");
		if (verticesLump == null)
			throw new IllegalStateException("vertexesLump not set yet");
		if (sectorsLump == null)
			throw new IllegalStateException("sectorsLump not set yet");

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
