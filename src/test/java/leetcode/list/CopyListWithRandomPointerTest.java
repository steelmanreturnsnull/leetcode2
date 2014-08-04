package leetcode.list;

import leetcode.model.RandomListNode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CopyListWithRandomPointerTest {
	CopyListWithRandomPointer	test	= new CopyListWithRandomPointer();

	@Test
	public void test() {
		RandomListNode a = new RandomListNode(1);
		RandomListNode b = new RandomListNode(2);
		RandomListNode c = new RandomListNode(3);
		RandomListNode d = new RandomListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		a.random = a;
		b.random = d;
		d.random = b;

		Assert.assertEquals(test.copyRandomList(a).toString(), "{1#1,2#4,3#null,4#2}");
		Assert.assertEquals(test.copyRandomListII(a).toString(), "{1#1,2#4,3#null,4#2}");
		Assert.assertEquals(a.toString(), "{1#1,2#4,3#null,4#2}");
	}
}
