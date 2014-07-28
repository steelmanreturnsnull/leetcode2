package leetcode.string;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Clarification:
 * 
 * What constitutes a word? A sequence of non-space characters constitutes a word.
 * 
 * Could the input string contain leading or trailing spaces? Yes. However, your reversed string should not contain leading or
 * trailing spaces.
 * 
 * How about multiple spaces between two words? Reduce them to a single space in the reversed string.
 * 
 */

public class ReverseWordsInAString {
	// O(N), O(N) space
	public String reverseWords(String s) {
		if (s == null) // Check null
			return null;
		StringBuilder sb = new StringBuilder();
		String[] parts = s.trim().split(" +");
		for (int i = parts.length - 1; i >= 0; i--) {
			sb.append(parts[i]).append(" ");
		}
		if (sb.length() > 0)
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
