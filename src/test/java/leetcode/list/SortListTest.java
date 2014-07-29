package leetcode.list;

import leetcode.list.SortList;
import leetcode.model.ListNode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortListTest {
	SortList	test	= new SortList();

	@Test
	public void test() {
		Assert.assertEquals(test.sortList(null), null);
		Assert.assertEquals(test.sortList(ListNode.buildFromString("{1}")).toString(), "{1}");
		Assert.assertEquals(test.sortList(ListNode.buildFromString("{1,1}")).toString(), "{1,1}");
		Assert.assertEquals(test.sortList(ListNode.buildFromString("{3,2,1}")).toString(), "{1,2,3}");
	}
}
