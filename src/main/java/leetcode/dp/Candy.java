package leetcode.dp;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get more candies than their neighbors. What is the minimum
 * candies you must give?
 * 
 */
public class Candy {

	// O(N), O(N) space
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;

		int[] left_scan = new int[ratings.length];
		left_scan[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				left_scan[i] = left_scan[i - 1] + 1;
			else
				left_scan[i] = 1;
		}

		int[] right_scan = new int[ratings.length];
		right_scan[ratings.length - 1] = 1;
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				right_scan[i] = right_scan[i + 1] + 1;
			else
				right_scan[i] = 1;
		}

		int result = 0;
		for (int i = 0; i < ratings.length; i++) {
			result += Math.max(left_scan[i], right_scan[i]);
		}
		return result;
	}
}
