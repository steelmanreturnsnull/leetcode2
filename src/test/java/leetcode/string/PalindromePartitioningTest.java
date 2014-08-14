package leetcode.string;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PalindromePartitioningTest {

	PalindromePartitioning	test	= new PalindromePartitioning();

	@Test
	public void test() {
		Assert.assertEquals(test.partition(null).toString(), "[]");
		Assert.assertEquals(test.partition("").toString(), "[]");
		Assert.assertEquals(test.partition("a").toString(), "[[a]]");
		Assert.assertEquals(test.partition("aab").toString(), "[[a, a, b], [aa, b]]");
		Assert.assertEquals(test.partition("abbab").toString(), "[[a, b, b, a, b], [a, b, bab], [a, bb, a, b], [abba, b]]");
		Assert.assertEquals(test.partition("gggasdf").toString(), "[[g, g, g, a, s, d, f], [g, gg, a, s, d, f], [gg, g, a, s, d, f], [ggg, a, s, d, f]]");
	}
}
