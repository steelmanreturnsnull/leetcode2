package leetcode;

import leetcode.model.ListNode;

public class SortList {
	public ListNode sortList(ListNode head) {
        
    }
	
	private ListNode sortList(ListNode head, int size) {
		ListNode p1 = sortList(head, size/2);
		ListNode middle = getNthNode(head, size/2);
		ListNode p2 = sortList(head, size - size/2);
		return merge(p1, p2);
	}
	
	private ListNode getNthNode(ListNode head, int n) {
		for (int i = 1; i <=n; i++)
			head = head.next;
		return head;
	}
	
	private ListNode merge(ListNode p1, ListNode p2) {
		return null;
	}
}
