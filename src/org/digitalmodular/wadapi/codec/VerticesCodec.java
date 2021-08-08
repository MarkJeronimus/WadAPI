package org.digitalmodular.wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.LumpUtilities;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.VerticesLump;
import org.digitalmodular.wadapi.structure.Vertex;

/**
 * @author Zom-B
 */
// Created 2011-08-14
@Singleton
public class VerticesCodec extends LumpCodec<VerticesLump> {
	private static final int VERTEX_FIELD_SIZE = 4;

	public static final VerticesCodec INSTANCE = new VerticesCodec();

	@Override
	public VerticesLump decode(FileBufferLump lump) {
		String     name       = lump.getName();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numVertices = LumpUtilities.calcNumFields(fileBuffer.remaining(), VERTEX_FIELD_SIZE, name);

		VerticesLump verticesLump = new VerticesLump(name, numVertices);

		for (int i = 0; i < numVertices; i++) {
			Vertex vertex = readVertex(fileBuffer);
			verticesLump.add(vertex);
		}

		return verticesLump;
	}

	@Override
	public void encode(VerticesLump verticesLump, FileBuffer buffer) {
		for (Vertex vertex : verticesLump)
			writeVertex(vertex, buffer);
	}

	private static Vertex readVertex(FileBuffer buffer) {
		int x = buffer.getShort();
		int y = buffer.getShort();

		return Vertex.fromMapUnits(x, y);
	}

	private static void writeVertex(Vertex vertex, FileBuffer buffer) {
		buffer.putShort((vertex.getX() + 32768) >> 16);
		buffer.putShort((vertex.getY() + 32768) >> 16);
	}
}
