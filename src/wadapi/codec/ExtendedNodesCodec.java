package wadapi.codec;

import java.util.logging.Logger;
import static java.util.logging.Level.WARNING;

import org.jetbrains.annotations.Nullable;

import org.digitalmodular.utilities.annotation.UtilityClass;

import wadapi.FileBuffer;
import wadapi.LumpType;
import wadapi.WadMap;
import wadapi.lump.FileBufferLump;
import wadapi.lump.NodesLump;
import wadapi.lump.SegmentsLump;
import wadapi.lump.SubsectorsLump;
import wadapi.lump.VerticesLump;
import wadapi.structure.Node;
import wadapi.structure.Segment;
import wadapi.structure.Subsector;
import wadapi.structure.Vertex;

/**
 * Handles XNOD nodes.
 * <p>
 * See https://zdoom.org/wiki/Node#ZDoom_extended_nodes
 *
 * @author Zom-B
 */
// Created 2011-08-15
@UtilityClass
public final class ExtendedNodesCodec {
	private ExtendedNodesCodec() {
		throw new AssertionError();
	}

	private static final int SIGNATURE_SIZE       = 4;
	private static final int VERTEX_FIELD_SIZE    = 8;
	private static final int SUBSECTOR_FIELD_SIZE = 4;
	private static final int SEGMENT_FIELD_SIZE   = 11;
	private static final int NODE_FIELD_SIZE      = 32;

	/**
	 * Decode an extended NODES lump (for now only the "XNOD" variant).
	 * <p>
	 * It's assumed the signature is 4 bytes, and is already been verified by the calling class.
	 * This decoder will explicitly skip to the 4th byte before decoding.
	 */
	public static void decode(FileBufferLump lump, WadMapBuilder builder) {
		@Nullable VerticesLump verticesLump = builder.getVerticesLump();
		if (verticesLump == null)
			throw new IllegalArgumentException(LumpType.VERTEXES + " not loaded yet");

		lump.getFileBuffer().position(SIGNATURE_SIZE);

		decodeVerticesPart(lump, verticesLump);               // Vertices are augmented.
		builder.setSubsectorsLump(decodeSubsectorPart(lump)); // Subsectors are only stored in the NODES lump.
		builder.setSegmentsLump(decodeSegmentsPart(lump));    // Segments   are only stored in the NODES lump.
		builder.setNodesLump(decodeNodesPart(lump));          // Nodes      are only stored in the NODES lump.
	}

	public static void encode(WadMap map, FileBuffer buffer) {
		throw new UnsupportedOperationException("Not implemented: " + ExtendedNodesCodec.class.getSimpleName() +
		                                        ".encode()");
	}

	private static void decodeVerticesPart(FileBufferLump lump, VerticesLump verticesLump) {
		String     lumpName   = lump.getName();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numOriginalVertices = fileBuffer.getInt();
		if (numOriginalVertices < 0 || numOriginalVertices >= 65536)
			throw new IllegalArgumentException("Corrupt or invalid extended " + lumpName +
			                                   " lump. Number of vertices according to the extended " + lumpName +
			                                   " lump = " + numOriginalVertices +
			                                   " (offset " + (fileBuffer.position() - 4) + ')');

		int numNewVertices = fileBuffer.getInt();
		int maxNumVertices = fileBuffer.remaining() / VERTEX_FIELD_SIZE;
		if (numNewVertices < 0 || numNewVertices > maxNumVertices)
			throw new IllegalArgumentException("Corrupt or invalid extended " + lumpName +
			                                   " lump. Number of new vertices incorrect: " + numNewVertices +
			                                   " (offset " + (fileBuffer.position() - 4) + ')');

		if (verticesLump.size() != numOriginalVertices)
			repairOriginalVertices(lumpName, verticesLump, numOriginalVertices);

		for (int i = 0; i < numNewVertices; i++) {
			int x = fileBuffer.getInt();
			int y = fileBuffer.getInt();
			verticesLump.add(Vertex.fromFixed(x, y));
		}
	}

	private static void repairOriginalVertices(String lumpName, VerticesLump verticesLump, int numOriginalVertices) {
		Logger.getGlobal().log(WARNING, "Length of " + verticesLump.getName() + " (" + verticesLump.size() +
		                                ") and number of vertices according to the extended " + lumpName +
		                                " lump (" + numOriginalVertices + " do not match! Attempting to repair " +
		                                verticesLump.getName() + '.');

		while (verticesLump.size() > numOriginalVertices)
			verticesLump.remove(verticesLump.size() - 1);

		while (verticesLump.size() < numOriginalVertices)
			verticesLump.add(Vertex.fromMapUnits(0, 0));
	}

	private static SubsectorsLump decodeSubsectorPart(FileBufferLump lump) {
		String     lumpName   = lump.getName();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numSubsectors    = fileBuffer.getInt();
		int maxNumSubsectors = fileBuffer.remaining() / SUBSECTOR_FIELD_SIZE;
		if (numSubsectors < 0 || numSubsectors > maxNumSubsectors)
			throw new IllegalArgumentException("Corrupt or invalid extended " + lumpName +
			                                   " lump. Number of subsectors incorrect: " + numSubsectors +
			                                   " (offset " + (fileBuffer.position() - 4) + ')');

		SubsectorsLump subsectorsLump = new SubsectorsLump(LumpType.SSECTORS.toString(), numSubsectors);

		int firstSeg = 0;
		for (int i = 0; i < numSubsectors; i++) {
			int numSegs = fileBuffer.getInt();

			subsectorsLump.add(new Subsector(numSegs, firstSeg));
			firstSeg += numSegs;
		}

		return subsectorsLump;
	}

	private static SegmentsLump decodeSegmentsPart(FileBufferLump lump) {
		String     lumpName   = lump.getName();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numSegments    = fileBuffer.getInt();
		int maxNumSegments = fileBuffer.remaining() / SEGMENT_FIELD_SIZE;
		if (numSegments < 0 || numSegments > maxNumSegments)
			throw new IllegalArgumentException("Corrupt or invalid extended " + lumpName +
			                                   " lump. Number of segments incorrect: " + numSegments +
			                                   " (offset " + (fileBuffer.position() - 4) + ')');

		SegmentsLump segmentsLump = new SegmentsLump(LumpType.SEGS.toString(), numSegments);

		for (int i = 0; i < numSegments; i++) {
			int     v1       = fileBuffer.getInt();
			int     v2       = fileBuffer.getInt();
			int     linedef  = fileBuffer.getUnsignedShort();
			boolean backSide = fileBuffer.getUnsignedByte() != 0;

			segmentsLump.add(new Segment(v1, v2, linedef, backSide));
		}

		return segmentsLump;
	}

	private static NodesLump decodeNodesPart(FileBufferLump lump) {
		String     lumpName   = lump.getName();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numNodes           = fileBuffer.getInt();
		int size               = fileBuffer.remaining();
		int numNodesCalculated = size / NODE_FIELD_SIZE;
		if (numNodes < 0 || numNodes > numNodesCalculated)
			throw new IllegalArgumentException("Corrupt or invalid extended " + lumpName +
			                                   " lump. Number of nodes incorrect: " + numNodes +
			                                   " (offset " + (fileBuffer.position() - 4) + ')');

		int extra = size - numNodes * NODE_FIELD_SIZE;
		if (extra != 0)
			Logger.getGlobal().log(WARNING, extra + " extra bytes after data: name = " + lumpName);

		NodesLump nodesLump = new NodesLump(lump.getName(), numNodes);

		for (int i = 0; i < numNodes; i++) {
			Node node = readNode(fileBuffer);
			nodesLump.add(node);
		}

		return nodesLump;
	}

	private static Node readNode(FileBuffer buffer) {
		int x       = buffer.getShort();
		int y       = buffer.getShort();
		int dx      = buffer.getShort();
		int dy      = buffer.getShort();
		int bbox0y2 = buffer.getShort();
		int bbox0y1 = buffer.getShort();
		int bbox0x1 = buffer.getShort();
		int bbox0x2 = buffer.getShort();
		int bbox1y2 = buffer.getShort();
		int bbox1y1 = buffer.getShort();
		int bbox1x1 = buffer.getShort();
		int bbox1x2 = buffer.getShort();
		int child0  = buffer.getInt();
		int child1  = buffer.getInt();

		return new Node(x << 16,
		                y << 16,
		                dx << 16,
		                dy << 16,
		                bbox0y2 << 16,
		                bbox0y1 << 16,
		                bbox0x1 << 16,
		                bbox0x2 << 16,
		                bbox1y2 << 16,
		                bbox1y1 << 16,
		                bbox1x1 << 16,
		                bbox1x2 << 16,
		                (child0 & 0x80000000) == 0 ? child0 & 0x7FFFFFFF : -1,
		                (child1 & 0x80000000) == 0 ? child1 & 0x7FFFFFFF : -1,
		                (child0 & 0x80000000) != 0 ? child0 & 0x7FFFFFFF : -1,
		                (child1 & 0x80000000) != 0 ? child1 & 0x7FFFFFFF : -1);
	}
}
