package leetcode.list;

import leetcode.model.ListNode;

/**
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn, reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 */
public class ReorderList {

	// O(N), O(1) space
	public void reorderList(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		if (fast == null || fast.next == null)
			return;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		fast = slow.next;
		slow.next = null;
		slow = null;
		while (fast != null) {
			ListNode next = fast.next;
			fast.next = slow;
			slow = fast;
			fast = next;
		}

		fast = slow;
		slow = head;
		while (slow != null && fast != null) {
			ListNode nextSlow = slow.next;
			slow.next = fast;
			ListNode nextFast = fast.next;
			fast.next = nextSlow;
			slow = nextSlow;
			fast = nextFast;
		}
	}
}
