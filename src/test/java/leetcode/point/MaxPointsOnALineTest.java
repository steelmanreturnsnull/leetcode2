package leetcode.point;

import leetcode.model.Point;
import leetcode.point.MaxPointsOnALine;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaxPointsOnALineTest {
	MaxPointsOnALine	test	= new MaxPointsOnALine();

	@Test
	public void test() {
		Point[] input1 = {};
		Point[] input2 =
		{
			new Point(0, 0)
		};
		Point[] input3 =
		{
				new Point(0, 0), new Point(3, 1), new Point(6, 2), new Point(5, 5)
		};
		Point[] input4 =
		{
				new Point(1, 0), new Point(2, 0), new Point(6, 0), new Point(5, 5)
		};
		Point[] input5 =
		{
				new Point(0, 0), new Point(1, 0), new Point(-1, 0), new Point(0, 1), new Point(0, -1)
		};
		Point[] input6 =
		{
				new Point(0, 0), new Point(0, 1), new Point(0, -1)
		};

		Point[] f1 =
		{
				new Point(0, 0), new Point(0, 0)
		};
		Point[] f2 =
		{
				new Point(0, 0), new Point(0, 0), new Point(1, 1), new Point(1, 1)
		};
		Assert.assertEquals(test.maxPoints(input1), 0);
		Assert.assertEquals(test.maxPoints(input2), 1);
		Assert.assertEquals(test.maxPoints(input3), 3);
		Assert.assertEquals(test.maxPoints(input4), 3);
		Assert.assertEquals(test.maxPoints(input5), 3);
		Assert.assertEquals(test.maxPoints(input6), 3);
		Assert.assertEquals(test.maxPoints(f1), 2);
		Assert.assertEquals(test.maxPoints(f2), 4);
	}
}
