package wadapi.lump;

import java.util.ArrayList;
import java.util.List;

import wadapi.LumpType;
import wadapi.structure.Node;
import static wadapi.LumpType.NODES;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class NodesLump extends Lump {
	private final List<Node> nodes;

	public NodesLump(String name, int initialCapacity) {
		super(name);

		nodes = new ArrayList<>(initialCapacity);
	}

	public List<Node> getNodes() {
		return nodes;
	}

	@Override
	public LumpType getLumpType() {
		return NODES;
	}
}
