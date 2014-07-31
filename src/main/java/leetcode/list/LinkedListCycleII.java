package leetcode.list;

import leetcode.model.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 */
public class LinkedListCycleII {

	// O(N), O(1) space
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = head;
				while (slow != fast) { // a + b = n*x, so before b steps, they are both at start of cycle
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
}
