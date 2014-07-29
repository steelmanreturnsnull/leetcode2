package leetcode.math;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 */

//  Reverse Polish calculators do not need expressions to be parenthesized.
public class EvaluateReversePolishNotation {

	// O(N), O(N) space
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String s : tokens) {
			try {
				int i = Integer.parseInt(s);
				stack.push(i);
			} catch (NumberFormatException e) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				switch (s) {  //switch on String valid after JDK 1.7
					case "+":
						stack.push(num1 + num2);
						break;
					case "-":
						stack.push(num1 - num2);
						break;
					case "*":
						stack.push(num1 * num2);
						break;
					case "/":
						stack.push(num1 / num2);
						break;
				}
			}
		}
		return stack.pop();
	}
}
