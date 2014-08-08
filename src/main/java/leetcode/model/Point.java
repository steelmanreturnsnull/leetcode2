package leetcode.model;

public class Point {
	public int	x;
	public int	y;

	Point() {
		x = 0;
		y = 0;
	}

	public Point(int a, int b) {
		x = a;
		y = b;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(").append(x).append(",").append(y).append(")");
		return sb.toString();
	}
}
