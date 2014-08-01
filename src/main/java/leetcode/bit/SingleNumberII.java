package leetcode.bit;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one. Note: Your algorithm should
 * have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 */
public class SingleNumberII {

	// a solution easier to think
	// int[32] store all the results. int[32]%3 is what we want

	// Future thoughts: if one number appears twice, twos is the result

	// O(N), O(1) space
	public int singleNumber(int[] A) {
		int ones = 0, twos = 0;

		for (int a : A) {
			int newOnes = (ones ^ a) & (~twos);
			// why do we need ~twos here?
			// 1->2->3->1 ~two means it's in 3 state, so its safe.

			int newTwos = (ones & a) | (twos & ~a);
			ones = newOnes;
			twos = newTwos;
		}
		return ones;
	}
}
