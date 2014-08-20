package leetcode.number;

import leetcode.number.LongestConsecutiveSequence;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongestConsecutiveSequenceTest {

	LongestConsecutiveSequence	test	= new LongestConsecutiveSequence();

	@Test
	public void test() {
		Assert.assertEquals(test.longestConsecutive(null), 0);
		Assert.assertEquals(test.longestConsecutive(new int[] {}), 0);
		Assert.assertEquals(test.longestConsecutive(new int[]
		{
				-1, 1, 0
		}), 3);
	}
}
