package wadapi.lump;

import wadapi.structure.Node;
import static wadapi.LumpType.NODES;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class NodesLump extends ListLump<Node> {
	public NodesLump(String name, int initialCapacity) {
		super(name, NODES, "node", initialCapacity);
	}
}
