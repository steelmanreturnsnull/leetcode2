package leetcode.word;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary
 * word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 */
public class WordBreakII {

	// O(2^N), O(2^N) space
	// there's a O(N^3) DP solution, which records every route from one point to another

	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() == 0)
			return result;

		boolean[] contained = new boolean[s.length() + 1];
		contained[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int k = 0; k < i; k++) {
				if (contained[k] && dict.contains(s.substring(k, i))) {
					contained[i] = true;
					break;
				}
			}
		}

		if (contained[s.length()])
			dfs(s, dict, 0, 0, "", result);
		return result;
	}

	// a strange dfs though, at each node, decide to cut or not to cut
	public void dfs(String s, Set<String> dict, int start_idx, int current_idx, String current_result, List<String> result) {
		if (current_idx == s.length()) {
			if (start_idx == s.length())
				result.add(current_result.substring(1));
			return;
		}
		dfs(s, dict, start_idx, current_idx + 1, current_result, result);
		if (dict.contains(s.substring(start_idx, current_idx + 1))) {
			dfs(s, dict, current_idx + 1, current_idx + 1, current_result + " " + s.substring(start_idx, current_idx + 1), result);
		}
	}
}
