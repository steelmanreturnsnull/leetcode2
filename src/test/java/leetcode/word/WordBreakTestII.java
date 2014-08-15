package leetcode.word;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WordBreakTestII {

	WordBreakII					test	= new WordBreakII();
	private static Set<String>	dict	= new HashSet<>();

	WordBreakTestII() {
		dict.add("a");
		dict.add("le");
		dict.add("et");
		dict.add("leet");
		dict.add("code");
	}

	@Test
	public void test() {
		Assert.assertEquals(test.wordBreak(null, dict).toString(), "[]");
		Assert.assertEquals(test.wordBreak("", dict).toString(), "[]");
		Assert.assertEquals(test.wordBreak("a", dict).toString(), "[a]");
		Assert.assertEquals(test.wordBreak("leetcode", dict).toString(), "[leet code, le et code]");
		Assert.assertEquals(test.wordBreak("leetbcode", dict).toString(), "[]");
	}
}
