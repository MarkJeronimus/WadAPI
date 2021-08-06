package wadapi.codec;

import org.jetbrains.annotations.Nullable;

import org.digitalmodular.utilities.annotation.UtilityClass;

import wadapi.FileBuffer;
import wadapi.LumpType;
import wadapi.LumpUtilities;
import wadapi.lump.FileBufferLump;
import wadapi.lump.ListLump;
import wadapi.lump.NodesLump;
import wadapi.lump.SubsectorsLump;
import wadapi.structure.Node;

/**
 * @author Zom-B
 */
// Created 2011-08-15
@UtilityClass
public class DoomNodesCodec {
	private static final int NODE_FIELD_SIZE = 28;

	public static NodesLump decode(FileBufferLump lump, WadMapBuilder builder) {
		@Nullable SubsectorsLump subsectorsLump = builder.getSubsectorsLump();
		if (subsectorsLump == null)
			throw new IllegalArgumentException(LumpType.SSECTORS + " not loaded yet");

		FileBuffer fileBuffer = lump.getFileBuffer();
		int        numNodes   = LumpUtilities.calcNumFields(fileBuffer.remaining(), NODE_FIELD_SIZE, lump.getName());

		NodesLump nodesLump = new NodesLump(lump.getName(), numNodes);

		for (int i = 0; i < numNodes; i++) {
			Node node = readNode(lump, fileBuffer, nodesLump, subsectorsLump);
			nodesLump.add(node);
		}

		return nodesLump;
	}

	public static void encode(NodesLump nodes, FileBuffer buffer) {
		throw new UnsupportedOperationException("Not implemented: " + DoomNodesCodec.class.getSimpleName() +
		                                        ".encode()");
	}

	private static Node readNode(
			FileBufferLump lump, FileBuffer buffer, NodesLump nodesLump, SubsectorsLump subsectorsLump) {
		int x          = buffer.getShort();
		int y          = buffer.getShort();
		int dx         = buffer.getShort();
		int dy         = buffer.getShort();
		int bbox0y2    = buffer.getShort();
		int bbox0y1    = buffer.getShort();
		int bbox0x1    = buffer.getShort();
		int bbox0x2    = buffer.getShort();
		int bbox1y2    = buffer.getShort();
		int bbox1y1    = buffer.getShort();
		int bbox1x1    = buffer.getShort();
		int bbox1x2    = buffer.getShort();
		int child0Code = buffer.getShort();
		int child1Code = buffer.getShort();

		ListLump<?> child0Source = (child0Code & 0x8000) == 0 ? nodesLump : subsectorsLump;
		ListLump<?> child1Source = (child1Code & 0x8000) == 0 ? nodesLump : subsectorsLump;
		child0Code &= 0x7FFF;
		child1Code &= 0x7FFF;

		if (child0Code >= child0Source.size())
			throw new IllegalArgumentException("Corrupt or invalid " + lump.getName() +
			                                   " lump. " + child0Source.getName() + " index out of bounds: " +
			                                   child0Code + " (size = " + child0Source.size() + ')');
		if (child1Code >= child1Source.size())
			throw new IllegalArgumentException("Corrupt or invalid " + lump.getName() +
			                                   " lump. " + child1Source.getName() + " index out of bounds: " +
			                                   child1Code + " (size = " + child1Source.size() + ')');

		Object child0 = child0Source.get(child0Code);
		Object child1 = child1Source.get(child1Code);

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
		                child0,
		                child1);
	}
}
