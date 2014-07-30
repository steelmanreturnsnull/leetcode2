package leetcode.list;

import leetcode.model.ListNode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InsertionSortListTest {
	InsertionSortList	test	= new InsertionSortList();

	@Test
	public void test() {
		Assert.assertEquals(test.insertionSortList(null), null);
		Assert.assertEquals(test.insertionSortList(ListNode.buildFromString("{1}")).toString(), "{1}");
		Assert.assertEquals(test.insertionSortList(ListNode.buildFromString("{1,1}")).toString(), "{1,1}");
		Assert.assertEquals(test.insertionSortList(ListNode.buildFromString("{3,2,1}")).toString(), "{1,2,3}");
		Assert.assertEquals(test.insertionSortList(ListNode.buildFromString("{4,2,3,1}")).toString(), "{1,2,3,4}");
		Assert.assertEquals(test.insertionSortList(ListNode.buildFromString("{3,-2,1}")).toString(), "{-2,1,3}");
		Assert.assertEquals(test.insertionSortList(ListNode.buildFromString("{-4,2,-3,1}")).toString(), "{-4,-3,1,2}");
	}
}
