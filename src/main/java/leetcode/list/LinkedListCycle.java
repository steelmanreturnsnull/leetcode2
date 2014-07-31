package leetcode.list;

import leetcode.model.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 */
public class LinkedListCycle {

	// O(N), O(1) space
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
