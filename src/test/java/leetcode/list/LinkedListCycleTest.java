package leetcode.list;

import leetcode.model.ListNode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedListCycleTest {
	LinkedListCycle	test	= new LinkedListCycle();

	@Test
	public void test() {
		Assert.assertEquals(test.hasCycle(null), false);
		Assert.assertEquals(test.hasCycle(ListNode.buildFromString("{1,2,3}")), false);
		Assert.assertEquals(test.hasCycle(ListNode.buildFromString("{1,2,3,2,3}")), false);

		ListNode n1 = new ListNode(1);
		n1.next = n1;
		Assert.assertEquals(test.hasCycle(n1), true);

		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;
		Assert.assertEquals(test.hasCycle(n2), true);
	}
}
