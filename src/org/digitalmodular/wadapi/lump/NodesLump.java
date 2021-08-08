package org.digitalmodular.wadapi.lump;

import org.digitalmodular.wadapi.structure.Node;
import static org.digitalmodular.wadapi.LumpType.NODES;

/**
 * @author Zom-B
 */
// Created 2018-01-21
public class NodesLump extends ListLump<Node> {
	public NodesLump(String name, int initialCapacity) {
		super(name, NODES, "node", initialCapacity);
	}
}
