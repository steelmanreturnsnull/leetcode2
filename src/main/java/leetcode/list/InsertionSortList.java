package leetcode.list;

import leetcode.model.ListNode;

/**
 * Sort a linked list using insertion sort.
 * 
 */
public class InsertionSortList {

	// Idea: create another list of dummy, insert into correct position of dummy
	// O(N^2), O(1) space
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;

		ListNode dummy = new ListNode(0);
		ListNode comp = head;

		while (comp != null) {
			ListNode prev = dummy;
			ListNode nextComp = comp.next;

			while (prev.next != null && prev.next.val < comp.val) {
				prev = prev.next;
			}
			comp.next = prev.next;
			prev.next = comp;

			comp = nextComp;
		}

		return dummy.next;
	}

}
