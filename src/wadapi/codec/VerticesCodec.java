package wadapi.codec;

import java.util.List;

import org.digitalmodular.utilities.annotation.Singleton;

import wadapi.FileBuffer;
import wadapi.LumpUtilities;
import wadapi.lump.FileBufferLump;
import wadapi.lump.VerticesLump;
import wadapi.structure.Vertex;

/**
 * @author Zom-B
 */
// Created 2011-08-14
@Singleton
public class VerticesCodec extends LumpCodec<VerticesLump> {
	private static final int VERTEX_FIELD_SIZE = 4;

	public static final VerticesCodec INSTANCE = new VerticesCodec();

	public VerticesCodec() {
		super(VerticesLump.class);
	}

	@Override
	public VerticesLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer = lump.getFileBuffer();
		int numVertices =
				LumpUtilities.calcNumFields(fileBuffer.remaining(), VERTEX_FIELD_SIZE, lump.getName());

		VerticesLump verticesLump = new VerticesLump(lump.getName(), numVertices);

		List<Vertex> vertices = verticesLump.getVertices();
		for (int i = 0; i < numVertices; i++) {
			Vertex vertex = readVertex(fileBuffer);
			vertices.add(vertex);
		}

		return verticesLump;
	}

	@Override
	public void encode(VerticesLump verticesLump, FileBuffer buffer) {
		List<Vertex> vertices = verticesLump.getVertices();
		for (Vertex vertex : vertices)
			writeVertex(vertex, buffer);
	}

	private static Vertex readVertex(FileBuffer buffer) {
		int x = buffer.getShort();
		int y = buffer.getShort();
		return new Vertex(x, y);
	}

	private static void writeVertex(Vertex vertex, FileBuffer buffer) {
		buffer.putShort((short)vertex.getX());
		buffer.putShort((short)vertex.getY());
	}
}
