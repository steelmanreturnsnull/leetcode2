package leetcode.math;

import leetcode.math.EvaluateReversePolishNotation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EvaluateReversePolishNotationTest {
	EvaluateReversePolishNotation	test	= new EvaluateReversePolishNotation();

	@Test
	public void test() {
		String[] input1 =
		{
				"2", "1", "+", "3", "*"
		};
		String[] input2 =
		{
				"4", "13", "5", "/", "+"
		};

		Assert.assertEquals(test.evalRPN(input1), 9);
		Assert.assertEquals(test.evalRPN(input2), 6);
	}
}
