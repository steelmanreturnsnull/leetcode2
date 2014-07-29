package leetcode.model;

public class ListNode {
	public int		val;
	public ListNode	next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	public static ListNode buildFromString(String str) {
		str = str.substring(1, str.length() - 1);
		String[] parts = str.split(",");
		ListNode dummy = new ListNode(0);
		ListNode iter = dummy;
		for (String s : parts) {
			int val = Integer.parseInt(s);
			ListNode current = new ListNode(val);
			iter.next = current;
			iter = current;
		}
		return dummy.next;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		ListNode iter = this;
		while (iter != null) {
			sb.append(iter.val).append(",");
			iter = iter.next;
		}
		sb.deleteCharAt(sb.length() - 1).append("}");
		return sb.toString();
	}
}