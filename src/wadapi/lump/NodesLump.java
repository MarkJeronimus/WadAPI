package wadapi.lump;

import java.util.ArrayList;
import java.util.Iterator;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.structure.Node;
import static wadapi.LumpType.NODES;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class NodesLump extends Lump implements Iterable<Node> {
	private final ArrayList<Node> nodes;

	public NodesLump(String name, int initialCapacity) {
		super(name, NODES);

		nodes = new ArrayList<>(initialCapacity);
	}

	public int numNodes() {
		return nodes.size();
	}

	public Node get(int index) {
		return nodes.get(index);
	}

	public void add(Node node) {
		nodes.add(requireNonNull(node, "node"));
	}

	public void set(int index, Node node) {
		nodes.set(index, requireNonNull(node, "node"));
	}

	public void remove(int index) {
		nodes.remove(index);
	}

	public void ensureCapacity(int newCapacity) {
		nodes.ensureCapacity(newCapacity);
	}

	@Override
	public Iterator<Node> iterator() {
		return nodes.iterator();
	}
}
