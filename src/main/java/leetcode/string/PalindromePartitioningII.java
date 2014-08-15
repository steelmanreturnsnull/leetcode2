package leetcode.string;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 */
public class PalindromePartitioningII {

	// O(N^2), O(N^2) space
	public int minCut(String s) {

		if (s == null || s.length() == 0)
			return 0;

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
		for (int i = s.length() - 1; i >= 0; i--) {
			if (!isP[i][s.length() - 1]) {
				int min = Integer.MAX_VALUE;
				for (int k = i; k < s.length() - 1; k++) {
					if (isP[i][k])
						min = Math.min(minCut[k + 1] + 1, min);
				}
				minCut[i] = min;
			}
		}
		return minCut[0];
	}
}
