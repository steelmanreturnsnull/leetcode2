package leetcode.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * 
 *     1
 *    / \
 *   /   \
 *  0 --- 2
 *       / \
 *       \_/
 *
 */

public class UndirectedGraphNode {
	public int							label;
	public List<UndirectedGraphNode>	neighbors;

	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		UndirectedGraphNode node = this;

		List<UndirectedGraphNode> set = new ArrayList<>();
		LinkedList<UndirectedGraphNode> unvisited = new LinkedList<>();
		unvisited.add(node);

		while (!unvisited.isEmpty()) {
			UndirectedGraphNode current = unvisited.pop();
			set.add(current);
			for (UndirectedGraphNode n : current.neighbors) {
				if (n != null && !set.contains(n)) {
					unvisited.add(n);
				}
			}
		}

		Collections.sort(set, new Comparator<UndirectedGraphNode>() {
			@Override
			public int compare(UndirectedGraphNode o1, UndirectedGraphNode o2) {
				return o1.label - o2.label;
			}
		});

		for (UndirectedGraphNode n : set) {
			sb.append(n.label).append(":");
			for (UndirectedGraphNode neighbor : n.neighbors) {
				sb.append(neighbor.label).append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("#");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("}");
		return sb.toString();
	}
}