package leetcode.word;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more
 * dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 */
public class WordBreak {

	// Comment 1: Don't use substring, use same string with index, save space!
	// DP! contained[i] = dict.contains(substring(0, i) || (contained[k] && dict.contains(substring(k, i))

	// O(N^2), O(N) space
	public boolean wordBreak(String s, Set<String> dict) {

		if (s == null || s.length() == 0)
			return true;

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
		return contained[s.length()];
	}
}
