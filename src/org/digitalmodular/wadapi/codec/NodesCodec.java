package org.digitalmodular.wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.LumpUtilities;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.NodesLump;
import org.digitalmodular.wadapi.structure.Node;

/**
 * @author Zom-B
 */
// Created 2011-08-15
@Singleton
public class NodesCodec extends LumpCodec<NodesLump> {
	private static final int NODE_FIELD_SIZE = 28;

	public static final NodesCodec INSTANCE = new NodesCodec();

	@Override
	public NodesLump decode(FileBufferLump lump) {
		String     name       = lump.getName();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numNodes = LumpUtilities.calcNumFields(fileBuffer.remaining(), NODE_FIELD_SIZE, name);

		NodesLump nodesLump = new NodesLump(name, numNodes);

		for (int i = 0; i < numNodes; i++) {
			Node node = readNode(fileBuffer);
			nodesLump.add(node);
		}

		return nodesLump;
	}

	@Override
	public void encode(NodesLump segmentsLump, FileBuffer buffer) {
		throw new UnsupportedOperationException("Not implemented: " + NodesCodec.class.getSimpleName() +
		                                        ".encode()");
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
		int child0  = buffer.getShort();
		int child1  = buffer.getShort();

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
		                (child0 & 0x8000) == 0 ? child0 & 0x7FFF : -1,
		                (child1 & 0x8000) == 0 ? child1 & 0x7FFF : -1,
		                (child0 & 0x8000) != 0 ? child0 & 0x7FFF : -1,
		                (child1 & 0x8000) != 0 ? child1 & 0x7FFF : -1);
	}
}
