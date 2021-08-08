package org.digitalmodular.wadapi.lump;

import java.awt.Rectangle;

import org.digitalmodular.wadapi.structure.Vertex;
import static org.digitalmodular.wadapi.LumpType.VERTEXES;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class VerticesLump extends ListLump<Vertex> {
	private static final Rectangle DUMMY_BOUNDING_BOX = new Rectangle(-16777216, -16777216, 33554432, 33554432);

	public VerticesLump(String name, int initialCapacity) {
		super(name, VERTEXES, "vertex", initialCapacity);
	}

	public Rectangle getBoundingBox() {
		if (isEmpty())
			return DUMMY_BOUNDING_BOX;
		else if (size() == 1)
			return new Rectangle(get(0).getX(), get(0).getY() - 16777216, 33554432, 33554432);

		Rectangle boundingBox = new Rectangle(get(0).getX(), get(0).getY(), 0, 0);

		for (int i = 1; i < size(); i++) {
			Vertex vertex = get(i);
			boundingBox.add(vertex.getX(), vertex.getY());
		}

		return boundingBox;
	}
}
