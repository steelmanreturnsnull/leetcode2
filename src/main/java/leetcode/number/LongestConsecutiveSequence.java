package leetcode.number;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 */
public class LongestConsecutiveSequence {

	// O(N), O(N) space
	public int longestConsecutive(int[] num) {

		int max = 0;
		if (num == null)
			return max;

		Set<Integer> set = new HashSet<>();

		for (int i : num) {
			set.add(i);
		}

		for (int i : num) {
			if (set.contains(i)) {
				set.remove(i);

				int start = i - 1;
				while (set.contains(start)) {
					set.remove(start);
					start--;
				}

				int end = i + 1;
				while (set.contains(end)) {
					set.remove(end);
					end++;
				}

				max = Math.max(max, end - start - 1);
			}
		}
		return max;
	}
}
