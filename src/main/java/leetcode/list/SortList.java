package leetcode.list;

import leetcode.model.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 */
public class SortList {

	// O(NlgN), O(1) space, O(lgN) call stack
	public ListNode sortList(ListNode head) {
		return mergeSortList(head);
	}

	private ListNode mergeSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) { // Use fast, slow pointers to find middle!!! (actually slower)
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode middle = slow.next; // Consider 2 element situation
		slow.next = null; // break it up!

		ListNode p1 = sortList(head);
		ListNode p2 = sortList(middle);
		return merge(p1, p2);
	}

	private ListNode merge(ListNode p1, ListNode p2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				current.next = p1;
				p1 = p1.next;
			} else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}
		while (p1 != null) {
			current.next = p1;
			p1 = p1.next;
			current = current.next;
		}
		while (p2 != null) {
			current.next = p2;
			p2 = p2.next;
			current = current.next;
		}
		return dummy.next;
	}
}
