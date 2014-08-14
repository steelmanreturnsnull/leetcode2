package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 */
public class PalindromePartitioning {

	// O(n*2^n), O(2^n) space (output space)
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		if (s == null || s.length() == 0)
			return result;

		boolean isP[][] = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			isP[i][i] = true;
		}
		for (int i = 0; i + 1 < s.length(); i++) {
			isP[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
		}

		for (int i = 0, j = 2; j < s.length(); j++) {
			for (int k = i, l = j; l < s.length(); k++, l++) {
				isP[k][l] = isP[k + 1][l - 1] && s.charAt(k) == s.charAt(l);
			}
		}

		dfs(s, 0, result, new ArrayList<String>(), isP);
		return result;
	}

	// H(n) = H(n-1) + H(n-2) + ... + H(1) + O(N)
	// H(n-1) = H(n-2) + ... + H(1) + O(N)
	// H(n) = 2H(n-1) + O(N) = 4H(n-2) + O(N) = 2^n H(1) + O(N) = O(n * 2^n)
	private void dfs(String s, int start, List<List<String>> result, List<String> current, boolean[][] isP) {
		if (start == s.length()) {
			result.add(new ArrayList<>(current));
		}
		for (int end = start; end < s.length(); end++) {
			if (isP[start][end]) {
				current.add(s.substring(start, end + 1)); // save memory space here is really important
				dfs(s, end + 1, result, current, isP);
				current.remove(current.size() - 1);
			}
		}
	}
}
