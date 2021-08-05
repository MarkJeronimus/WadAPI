package wadapi.lump;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.structure.Vertex;
import static wadapi.LumpType.VERTEXES;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class VerticesLump extends Lump implements Iterable<Vertex> {
	private static final Rectangle DUMMY_BOUNDING_BOX = new Rectangle(-256, -256, 512, 512);

	private final ArrayList<Vertex> vertices;

	public VerticesLump(String name, int initialCapacity) {
		super(name, VERTEXES);

		vertices = new ArrayList<>(initialCapacity);
	}

	public int numVertices() {
		return vertices.size();
	}

	public Vertex get(int index) {
		return vertices.get(index);
	}

	public void add(Vertex vertex) {
		vertices.add(requireNonNull(vertex, "vertex"));
	}

	public void set(int index, Vertex vertex) {
		vertices.set(index, requireNonNull(vertex, "vertex"));
	}

	public void remove(int index) {
		vertices.remove(index);
	}

	public void ensureCapacity(int newCapacity) {
		vertices.ensureCapacity(newCapacity);
	}

	public Rectangle getBoundingBox() {
		if (vertices.isEmpty())
			return DUMMY_BOUNDING_BOX;
		else if (vertices.size() == 1)
			return new Rectangle(vertices.get(0).getMapUnitX() - 256, vertices.get(0).getMapUnitY() - 256, 512, 512);

		Rectangle boundingBox = new Rectangle(vertices.get(0).getMapUnitX(), vertices.get(0).getMapUnitY(), 0, 0);

		for (int i = 1; i < vertices.size(); i++) {
			Vertex vertex = vertices.get(i);
			boundingBox.add(vertex.getMapUnitX(), vertex.getMapUnitY());
		}

		return boundingBox;
	}

	@Override
	public Iterator<Vertex> iterator() {
		return vertices.iterator();
	}
}
