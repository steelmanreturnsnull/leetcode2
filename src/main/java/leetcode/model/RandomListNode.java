package leetcode.model;

public class RandomListNode {
	public int	label;
	public RandomListNode	next, random;

	public RandomListNode(int x) {
		this.label = x;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		RandomListNode iter = this;
		while (iter != null) {
			sb.append(iter.label).append("#");
			if (iter.random != null)
				sb.append(iter.random.label);
			else
				sb.append("null");
			sb.append(",");
			iter = iter.next;
		}
		sb.deleteCharAt(sb.length() - 1).append("}");
		return sb.toString();
	}
}