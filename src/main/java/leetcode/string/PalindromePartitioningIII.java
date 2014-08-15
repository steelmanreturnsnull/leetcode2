package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return the minimum cut a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return ["aa","b"] since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 */
public class PalindromePartitioningIII {

	// O(N^2), O(N^2) space
	public List<String> minCut(String s) {

		if (s == null || s.length() == 0)
			return new ArrayList<>();

		boolean isP[][] = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			isP[i][i] = true;
		}
		for (int i = 0; i + 1 < s.length(); i++) {
			isP[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
		}

		// isP[i][j] depends on isP[i+1][j-1]
		// make sure you finish row [i+1] first

		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i + 2; j < s.length(); j++) {
				isP[i][j] = isP[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
			}
		}

		int minCut[] = new int[s.length()]; // 1-D array, much faster!! **Very important
		List<List<String>> bestCut = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			List<String> cut = new ArrayList<>();
			bestCut.add(cut);
		}

		for (int i = s.length() - 1; i >= 0; i--) {
			if (!isP[i][s.length() - 1]) {
				int min = Integer.MAX_VALUE;
				for (int k = i; k < s.length() - 1; k++) {
					if (isP[i][k] && minCut[k + 1] + 1 < min) {
						bestCut.get(i).clear();
						bestCut.get(i).add(s.substring(i, k + 1));
						bestCut.get(i).addAll(bestCut.get(k + 1));
					}
				}
				minCut[i] = min;
			} else {
				bestCut.get(i).add(s.substring(i));
			}
		}
		return bestCut.get(0);
	}
}
