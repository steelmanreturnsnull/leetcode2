package leetcode.string;

import leetcode.string.ReverseWordsInAString;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseWordsInAStringTest {

	ReverseWordsInAString test = new ReverseWordsInAString();
	
	@Test
	public void test() {
		Assert.assertEquals(test.reverseWords(""), "");
		Assert.assertEquals(test.reverseWords("   "), "");   // test only contain spaces
		Assert.assertEquals(test.reverseWords("apple"), "apple");
		Assert.assertEquals(test.reverseWords("the sky is blue"), "blue is sky the");
		Assert.assertEquals(test.reverseWords("  ihave   seen this  "), "this seen ihave");
		Assert.assertEquals(test.reverseWords(null), null);
	}
}
