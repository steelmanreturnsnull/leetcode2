package leetcode.string;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidPalindromeTest {

	ValidPalindrome	test	= new ValidPalindrome();

	@Test
	public void test() {
		Assert.assertEquals(test.isPalindrome(null), false);
		Assert.assertEquals(test.isPalindrome(""), true);
		Assert.assertEquals(test.isPalindrome(" "), true);
		Assert.assertEquals(test.isPalindrome("a"), true);
		Assert.assertEquals(test.isPalindrome("aba"), true);
		Assert.assertEquals(test.isPalindrome("abb"), false);
		Assert.assertEquals(test.isPalindrome("A man, a plan, a canal: Panama"), true);
		Assert.assertEquals(test.isPalindrome("race a car"), false);
		Assert.assertEquals(test.isPalindrome("9a8"), false);

		Assert.assertEquals(test.isPalindromeII(null), false);
		Assert.assertEquals(test.isPalindromeII(""), true);
		Assert.assertEquals(test.isPalindromeII(" "), true);
		Assert.assertEquals(test.isPalindromeII("a"), true);
		Assert.assertEquals(test.isPalindromeII("aba"), true);
		Assert.assertEquals(test.isPalindromeII("abb"), false);
		Assert.assertEquals(test.isPalindromeII("A man, a plan, a canal: Panama"), true);
		Assert.assertEquals(test.isPalindromeII("race a car"), false);
		Assert.assertEquals(test.isPalindromeII("9a8"), false);
	}
}
