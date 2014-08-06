package leetcode.word;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WordBreakTest {

	WordBreak					test	= new WordBreak();
	private static Set<String>	dict	= new HashSet<>();

	WordBreakTest() {
		dict.add("a");
		dict.add("leet");
		dict.add("code");
	}

	@Test
	public void test() {
		Assert.assertEquals(test.wordBreak(null, dict), true);
		Assert.assertEquals(test.wordBreak("", dict), true);
		Assert.assertEquals(test.wordBreak("a", dict), true);
		Assert.assertEquals(test.wordBreak("leetcode", dict), true);
		Assert.assertEquals(test.wordBreak("leetbcode", dict), false);
	}
}
