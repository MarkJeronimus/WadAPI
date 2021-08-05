package wadapi.lump;

import java.awt.Rectangle;

import wadapi.structure.Vertex;
import static wadapi.LumpType.VERTEXES;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class VerticesLump extends ListLump<Vertex> {
	private static final Rectangle DUMMY_BOUNDING_BOX = new Rectangle(-256, -256, 512, 512);

	public VerticesLump(String name, int initialCapacity) {
		super(name, VERTEXES, "vertex", initialCapacity);
	}

	public Rectangle getBoundingBox() {
		if (isEmpty())
			return DUMMY_BOUNDING_BOX;
		else if (size() == 1)
			return new Rectangle(get(0).getMapUnitX() - 256, get(0).getMapUnitY() - 256, 512, 512);

		Rectangle boundingBox = new Rectangle(get(0).getMapUnitX(), get(0).getMapUnitY(), 0, 0);

		for (int i = 1; i < size(); i++) {
			Vertex vertex = get(i);
			boundingBox.add(vertex.getMapUnitX(), vertex.getMapUnitY());
		}

		return boundingBox;
	}
}
