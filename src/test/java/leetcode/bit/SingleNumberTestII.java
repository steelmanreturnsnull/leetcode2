package leetcode.bit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleNumberTestII {
	SingleNumberII	test	= new SingleNumberII();

	@Test
	public void test() {
		int a[] =
		{
				1, 3, 5, 7, 5, 3, 1, 3, 1, 5
		};
		int b[] =
		{
			2
		};
		int c[] =
		{
				25, 53, -25, -25, 25, 25, -25
		};
		Assert.assertEquals(test.singleNumber(a), 7);
		Assert.assertEquals(test.singleNumber(b), 2);
		Assert.assertEquals(test.singleNumber(c), 53);
	}
}
