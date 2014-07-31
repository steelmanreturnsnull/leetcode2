package leetcode.list;

import leetcode.model.ListNode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReorderListTest {
	ReorderList	test	= new ReorderList();

	@Test
	public void test() {
		ListNode nullNode = null;
		test.reorderList(nullNode);
		Assert.assertEquals(nullNode, null);

		ListNode l1 = ListNode.buildFromString("{1}");
		test.reorderList(l1);
		Assert.assertEquals(l1.toString(), "{1}");

		ListNode l2 = ListNode.buildFromString("{1,2}");
		test.reorderList(l2);
		Assert.assertEquals(l2.toString(), "{1,2}");

		ListNode l3 = ListNode.buildFromString("{1,2,3}");
		test.reorderList(l3);
		Assert.assertEquals(l3.toString(), "{1,3,2}");

		ListNode l4 = ListNode.buildFromString("{1,2,3,4}");
		test.reorderList(l4);
		Assert.assertEquals(l4.toString(), "{1,4,2,3}");

		ListNode l5 = ListNode.buildFromString("{1,2,3,4,5,6,7}");
		test.reorderList(l5);
		Assert.assertEquals(l5.toString(), "{1,7,2,6,3,5,4}");
	}

}
