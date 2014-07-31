package leetcode.point;

import java.util.HashMap;
import java.util.Map;

import leetcode.model.Point;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 */
public class MaxPointsOnALine {
	// O(N^2), O(N) space
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;

		int global_max = 0;
		for (Point p1 : points) {
			int local_max = 0;
			Map<Double, Integer> map = new HashMap<>();
			int no_slope_cnt = 0;
			int overlap_cnt = 0;
			for (Point p2 : points) {
				if (p1 == p2)
					continue;
				if (p1.x == p2.x && p1.y == p2.y) // Overlap points counts for every slope!
					overlap_cnt++;
				else if (p1.x == p2.x)
					no_slope_cnt++;
				else { // Optimize: only calculate p1.x > p2.x
					double slope = (p2.y - p1.y) / (double) (p2.x - p1.x);
					if (map.containsKey(slope))
						map.put(slope, map.get(slope) + 1);
					else
						map.put(slope, 1);
				}
			}
			for (int count : map.values()) {
				if (count + overlap_cnt > local_max)
					local_max = count + overlap_cnt;
			}
			if (no_slope_cnt + overlap_cnt > local_max)
				local_max = no_slope_cnt + overlap_cnt;

			if (local_max > global_max)
				global_max = local_max;
		}
		return global_max + 1;
	}
}
