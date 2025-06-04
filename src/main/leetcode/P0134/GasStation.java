package P0134;

/**
 * LeetCode 134 - Gas Station
 * https://leetcode.com/problems/gas-station/
 *
 * Approach (Greedy):
 * - Use a greedy strategy to find the valid starting gas station index
 * - Track total net gas (total += gas[i] - cost[i]) to check if a solution is possible
 * - Track current tank balance while traversing the array
 * - If tank becomes negative, reset the starting index to the next station and reset tank to 0
 * - After the loop, if total >= 0, return the recorded start index; otherwise return -1
 *
 * Time: O(n), where n is the number of gas stations
 * Space: O(1), constant space
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            total += gain;
            tank += gain;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++) {
            if(canLoop(gas, cost, i)) {
                return i;
            }
        }
        return -1;
    }
    public boolean canLoop(int[] gas, int[] cost, int idx) {

        int index = idx;
        int currGas = gas[idx];
        boolean backToFront = false;

        while(currGas - cost[idx] >= 0) {
            if(idx == index && backToFront == true) {
                return true;
            }
            currGas = currGas - cost[idx] + gas[idx == gas.length - 1 ? 0 : idx + 1];
            if(idx == gas.length - 1) {
                idx = 0;
                backToFront = true;
            } else {
                idx++;
            }
        }
        return false;
    }

}
