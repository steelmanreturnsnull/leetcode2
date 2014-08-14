package leetcode.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GasStationTest {
	GasStation	test	= new GasStation();

	@Test
	public void test() {
		Assert.assertEquals(test.canCompleteCircuit(new int[] {}, new int[] {}), -1);
		Assert.assertEquals(test.canCompleteCircuit(new int[]
		{
				-1, -1, -1, 2, -1, -1, -1, 4
		}, null), -1);
		Assert.assertEquals(test.canCompleteCircuit(null, new int[]
		{
				-1, -1, -1, 2, -1, -1, -1, 4
		}), -1);
		Assert.assertEquals(test.canCompleteCircuit(null, null), -1);
		Assert.assertEquals(test.canCompleteCircuit(new int[]
		{
				-1, -1, -1, 2, -1, -1, -1, 4
		}, new int[]
		{
				-1, -1, -1, 2, -1, -1, -1, 4, 5
		}), -1);
		Assert.assertEquals(test.canCompleteCircuit(new int[]
		{
				-1, -1, -1, 2, -1, -1, -1, 4
		}, new int[]
		{
				0, 0, 0, 0, 0, 0, 0, 0
		}), 7);
		Assert.assertEquals(test.canCompleteCircuit(new int[]
		{
				-1, -1, -1, 4, -1, -1, -1, 2
		}, new int[]
		{
				0, 0, 0, 0, 0, 0, 0, 0
		}), 3);
		Assert.assertEquals(test.canCompleteCircuit(new int[]
		{
				-1, -1, -1, 4, -1, -1, -1, 2, -1, -1
		}, new int[]
		{
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0
		}), -1);
	}
}
