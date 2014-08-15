package leetcode.string;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PalindromePartitioningTestIII {

	PalindromePartitioningIII	test	= new PalindromePartitioningIII();

	@Test
	public void test() {
		Assert.assertEquals(test.minCut(null).toString(), "[]");
		Assert.assertEquals(test.minCut("").toString(), "[]");
		Assert.assertEquals(test.minCut("a").toString(), "[a]");
		Assert.assertEquals(test.minCut("aab").toString(), "[aa, b]");
		Assert.assertEquals(test.minCut("abbab").toString(), "[abba, b]");
		Assert.assertEquals(test.minCut("gggasdf").toString(), "[ggg, a, s, d, f]");
	}
}
