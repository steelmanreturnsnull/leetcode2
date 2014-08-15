package leetcode.string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 */
public class ValidPalindrome {

	// O(N), O(1) space
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;

		if (s.isEmpty())
			return true;

		int start = 0;
		int end = s.length() - 1;

		while (true) {

			while (start < s.length() && !Character.isLetterOrDigit(s.charAt(start)))
				// Out of bound!
				start++;

			while (end >= 0 && !Character.isLetterOrDigit(s.charAt(end)))
				// Out of bound!
				end--;

			if (start >= end) // greater than!
				return true;

			if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
				return false;

			start++; // make the loop going!
			end--;

		}
	}

	// A neater solution, only move one step when invalid
	// O(N), O(1) space
	public boolean isPalindromeII(String s) {
		if (s == null)
			return false;

		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
				continue;
			}
			if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--)))
				return false;
		}
		return true;
	}

}
