package leetcode.graph;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SurroundedRegionsTest {
	SurroundedRegions	test	= new SurroundedRegions();
	char				x		= 'X';
	char				o		= 'O';
	char[][]			board	= new char[][]
								{
			{
			x, x, x, x, x
			},
			{
			x, o, o, x, x
			},
			{
			x, x, o, x, x
			},
			{
			x, o, x, x, x
			}
								};
	char[][]			board2	= new char[][]
								{
			{
			x, x, x
			},
			{
			x, o, x
			},
			{
			x, x, x
			}
								};
	char[][]			board3	= new char[][]
								{
			{
			x, o, x, o, x, o
			},
			{
			o, x, o, x, o, x
			},
			{
			x, o, x, o, x, o
			},
			{
			o, x, o, x, o, x
			}
								};

	@Test
	public void test() {
		test.solve(board);
		StringBuilder sb = new StringBuilder();
		for (char[] chars : board) {
			sb.append(new String(chars));
		}
		Assert.assertEquals(sb.toString(), "XXXXXXXXXXXXXXXXOXXX");
	}

	@Test
	public void test2() {
		test.solve(board2);
		StringBuilder sb = new StringBuilder();
		for (char[] chars : board2) {
			sb.append(new String(chars));
		}
		Assert.assertEquals(sb.toString(), "XXXXXXXXX");
	}

	@Test
	public void test3() {
		test.solve(board3);
		StringBuilder sb = new StringBuilder();
		for (char[] chars : board3) {
			sb.append(new String(chars));
		}
		Assert.assertEquals(sb.toString(), "");
	}
}
