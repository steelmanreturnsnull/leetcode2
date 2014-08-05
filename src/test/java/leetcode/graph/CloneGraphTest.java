package leetcode.graph;

import org.testng.Assert;
import org.testng.annotations.Test;

import leetcode.graph.CloneGraph;
import leetcode.model.UndirectedGraphNode;

public class CloneGraphTest {
	CloneGraph	test	= new CloneGraph();

	@Test
	public void test() {
		UndirectedGraphNode a = new UndirectedGraphNode(0);
		UndirectedGraphNode b = new UndirectedGraphNode(1);
		UndirectedGraphNode c = new UndirectedGraphNode(2);
		a.neighbors.add(b);
		b.neighbors.add(a);
		b.neighbors.add(c);
		c.neighbors.add(b);
		c.neighbors.add(c);

		Assert.assertEquals(test.cloneGraph(a).toString(), "{0:1#1:0,2#2:1,2}");
		Assert.assertEquals(test.cloneGraphII(a).toString(), "{0:1#1:0,2#2:1,2}");
		Assert.assertEquals(a.toString(), "{0:1#1:0,2#2:1,2}");
	}
}
