package leetcode.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CandyTest {
	Candy	test	= new Candy();

	@Test
	public void test() {
		Assert.assertEquals(test.candy(null), 0);
		Assert.assertEquals(test.candy(new int[] {}), 0);
		Assert.assertEquals(test.candy(new int[]
		{
				1, 2, 3, 4
		}), 10);
		Assert.assertEquals(test.candy(new int[]
		{
				4, 3, 2, 1
		}), 10);
		Assert.assertEquals(test.candy(new int[]
		{
				1, 5, 9, 1
		}), 7);
		Assert.assertEquals(test.candy(new int[]
		{
				1, 1, 1, 1
		}), 4);
	}
}
