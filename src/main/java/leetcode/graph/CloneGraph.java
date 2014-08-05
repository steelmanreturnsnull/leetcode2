package leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import leetcode.model.UndirectedGraphNode;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 */
public class CloneGraph {
	
	// O(N^2), O(N) space
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		// do it in one pass, copy neighbors while creating them
		
        if (node == null)
        	return node;
		
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> old2NewMapping = new HashMap<>();
        
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        queue.add(node);
        old2NewMapping.put(node, newHead);
        
        while (!queue.isEmpty()) {
        	UndirectedGraphNode current = queue.pop();
        	for (UndirectedGraphNode neighbor : current.neighbors) {
        		if (!old2NewMapping.containsKey(neighbor)) {
        			UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
        			old2NewMapping.put(neighbor, newNode);
        			old2NewMapping.get(current).neighbors.add(newNode);
        			queue.add(neighbor);
        		}
        		else {
        			old2NewMapping.get(current).neighbors.add(old2NewMapping.get(neighbor));
        		}
        	}
        }
        
        return newHead;
    }
	
	// O(N^2), O(N) space
	public UndirectedGraphNode cloneGraphII(UndirectedGraphNode node) {
        if (node == null)
        	return node;
		
		Set<UndirectedGraphNode> set = new HashSet<>();
        Stack<UndirectedGraphNode> unvisited = new Stack<>();
        unvisited.add(node);
        
        while (!unvisited.isEmpty()) {
        	UndirectedGraphNode current = unvisited.pop();
        	set.add(current);
        	for (UndirectedGraphNode n : current.neighbors) { // only add to unvisited if they are unvisited!
        		if (n!= null && !set.contains(n)) {
        			unvisited.add(n);
        		}
        	}
        }
        
        Map<UndirectedGraphNode, UndirectedGraphNode> old2NewMapping = new HashMap<>();
        
        for (UndirectedGraphNode old : set) {
        	UndirectedGraphNode newNode = new UndirectedGraphNode(old.label);
        	old2NewMapping.put(old, newNode);
        }
        
        for (UndirectedGraphNode old : set) {
        	UndirectedGraphNode newNode = old2NewMapping.get(old);
        	for (UndirectedGraphNode neighbor: old.neighbors) {
        		newNode.neighbors.add(old2NewMapping.get(neighbor));
        	}
        }
        
        return old2NewMapping.get(node);
    }
}
