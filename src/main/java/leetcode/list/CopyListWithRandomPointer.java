package leetcode.list;

import java.util.HashMap;
import java.util.Map;

import leetcode.model.RandomListNode;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or
 * null.
 * 
 * Return a deep copy of the list.
 * 
 */
public class CopyListWithRandomPointer {

	// O(N), O(N) space
	public RandomListNode copyRandomList(RandomListNode head) {

		Map<RandomListNode, RandomListNode> oldToNewMap = new HashMap<>();

		RandomListNode iter = head;
		while (iter != null) {
			RandomListNode newNode = new RandomListNode(iter.label);
			newNode.next = iter.next;
			newNode.random = iter.random;
			oldToNewMap.put(iter, newNode);
			iter = iter.next;
		}

		RandomListNode newHead = oldToNewMap.get(head);
		iter = newHead;

		while (iter != null) {
			iter.next = oldToNewMap.get(iter.next);
			iter.random = oldToNewMap.get(iter.random);
			iter = iter.next;
		}

		return newHead;
	}

	// O(N), O(1*) space (not counting result)
	public RandomListNode copyRandomListII(RandomListNode head) {

		if (head == null)
			return head;

		// S1: insert new node after old node
		RandomListNode iter = head;
		while (iter != null) {
			RandomListNode newNode = new RandomListNode(iter.label);
			newNode.next = iter.next;
			newNode.random = iter.random;

			iter.next = newNode;
			iter = newNode.next;
		}

		// S2: correct random pointer
		iter = head.next;
		RandomListNode newHead = iter;
		while (iter != null) {
			if (iter.random != null)
				iter.random = iter.random.next;
			if (iter.next != null)
				iter = iter.next.next;
			else
				iter = null;
		}

		// S3: separate two lists
		iter = head;
		while (iter != null && iter.next != null) {
			RandomListNode nextIter = iter.next;
			iter.next = iter.next.next;
			iter = nextIter;
		}

		return newHead;
	}
}
