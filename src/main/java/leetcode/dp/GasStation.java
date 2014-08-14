package leetcode.dp;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You
 * begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 * 
 */
public class GasStation {

	// O(N), O(1) space
	public int canCompleteCircuit(int[] gas, int[] cost) {

		if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length)
			return -1;

		int debt = 0;
		int start_idx = -1;
		int remaining_gas = 0;

		for (int i = 0; i < gas.length; i++) {

			if (start_idx == -1) {
				if (gas[i] >= cost[i]) {
					start_idx = i;
					remaining_gas = gas[i] - cost[i];
				} else {
					debt += gas[i] - cost[i];
				}
			}

			else {
				if (remaining_gas + gas[i] - cost[i] >= 0) {
					remaining_gas += gas[i] - cost[i];
				} else {
					start_idx = -1;
					debt += remaining_gas + gas[i] - cost[i];
					remaining_gas = 0;
				}
			}

		}

		if (remaining_gas + debt >= 0)
			return start_idx;

		return -1;
	}
}
