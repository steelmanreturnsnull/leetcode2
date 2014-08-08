package interview.computationalgeometry;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.Point;

public class FindConvexHull {

	// Google Interview Question
	// Gift wrapping algorithm
	// aka Jarvis march
	// O(nh), where h number of output points, output-sensitive algorithm
	List<Point> giftWrappingAlgorithm(List<Point> points) {

		List<Point> result = new ArrayList<>();

		if (points == null || points.size() < 3)
			return result;

		int leftMost = findLeftMostPointIndex(points);
		int p = leftMost;

		do {
			int q = (p + 1) % points.size(); // must start with sth other than p
			for (int i = 0; i < points.size(); i++)
				if (CCW(points.get(p), points.get(q), points.get(i)))
					q = i;
			result.add(points.get(q));
			p = q;
		} while (p != leftMost);
		return result;
	}

	private int findLeftMostPointIndex(List<Point> points) {
		int leftMost = 0;
		for (int i = 1; i < points.size(); i++) {
			if (points.get(i).x < points.get(leftMost).x) {
				leftMost = i;
			}
		}
		return leftMost;
	}

	private boolean CCW(Point o, Point a, Point b) {
		// z coordinate of cross product of
		// Vector1 (a->o) (x2-x1, y2-y1, 0) and Vector2 (b->o) (x3-x1, y3-y1, 0)
		// is less than 0
		// right-hand rule
		return (a.x - o.x) * (b.y - o.y) - (b.x - o.x) * (a.y - o.y) > 0;
	}
}
