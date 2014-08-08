package interview.computationalgeometry;

import interview.computationalgeometry.FindConvexHull;

import java.util.Arrays;

import leetcode.model.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindConvexHullTest {

	FindConvexHull	test	= new FindConvexHull();

	@Test
	public void test() {

		Point[] points = null;
		Assert.assertEquals(test.giftWrappingAlgorithm(null).toString(), "[]");

		points = new Point[]
		{
			new Point(0, 0)
		};
		Assert.assertEquals(test.giftWrappingAlgorithm(Arrays.asList(points)).toString(), "[]");

		points = new Point[]
		{
				new Point(0, 0), new Point(1, 3)
		};
		Assert.assertEquals(test.giftWrappingAlgorithm(Arrays.asList(points)).toString(), "[]");

		points = new Point[]
		{
				new Point(0, 0), new Point(1, 3), new Point(3, 3)
		};
		Assert.assertEquals(test.giftWrappingAlgorithm(Arrays.asList(points)).toString(), "[(1,3), (3,3), (0,0)]");

		points = new Point[]
		{
				new Point(0, 0), new Point(1, 3), new Point(1, 1), new Point(2, 3), new Point(5, 5), new Point(7, 3), new Point(6, 0)
		};
		Assert.assertEquals(test.giftWrappingAlgorithm(Arrays.asList(points)).toString(), "[(1,3), (5,5), (7,3), (6,0), (0,0)]");

		points = new Point[]
		{
				new Point(0, 0), new Point(1, 1), new Point(1, 0), new Point(2, 0), new Point(2, 1), new Point(2, 2)
		};
		Assert.assertEquals(test.giftWrappingAlgorithm(Arrays.asList(points)).toString(), "[(1,1), (2,2), (2,0), (0,0)]");
	}
}
