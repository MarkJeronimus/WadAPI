package wadapi.lump;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import wadapi.LumpType;
import wadapi.structure.Vertex;
import static wadapi.LumpType.VERTEXES;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class VerticesLump extends Lump {
	private static final Rectangle DUMMY_BOUNDING_BOX = new Rectangle(-256, -256, 512, 512);

	private final List<Vertex> vertices;

	public VerticesLump(String name, int initialCapacity) {
		super(name);

		vertices = new ArrayList<>(initialCapacity);
	}

	public List<Vertex> getVertices() {
		return vertices;
	}

	@Override
	public LumpType getLumpType() {
		return VERTEXES;
	}

	public Rectangle getBoundingBox() {
		if (vertices.isEmpty())
			return DUMMY_BOUNDING_BOX;
		else if (vertices.size() == 1)
			return new Rectangle(vertices.get(0).getX() - 256, vertices.get(0).getY() - 256, 512, 512);

		Rectangle boundingBox = new Rectangle(vertices.get(0).getX(), vertices.get(0).getY(), 0, 0);

		for (int i = 1; i < vertices.size(); i++) {
			Vertex vertex = vertices.get(i);
			boundingBox.add(vertex.getX(), vertex.getY());
		}

		return boundingBox;
	}
}
