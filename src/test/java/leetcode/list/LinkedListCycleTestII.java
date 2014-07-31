package leetcode.list;

import leetcode.model.ListNode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedListCycleTestII {
	LinkedListCycleII	test	= new LinkedListCycleII();

	@Test
	public void test() {
		Assert.assertEquals(test.detectCycle(null), null);
		Assert.assertEquals(test.detectCycle(ListNode.buildFromString("{1,2,3}")), null);
		Assert.assertEquals(test.detectCycle(ListNode.buildFromString("{1,2,3,2,3}")), null);

		ListNode n1 = new ListNode(1);
		n1.next = n1;
		Assert.assertEquals(test.detectCycle(n1).val, 1);

		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;
		Assert.assertEquals(test.detectCycle(n2).val, 3);
	}
}
