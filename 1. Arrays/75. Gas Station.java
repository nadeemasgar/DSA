// https://leetcode.com/problems/gas-station/

// TC - O(n)
// SC - O(1)

import java.util.Arrays;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();

        if(gasSum < costSum) return -1;

        int remaining_fuel = 0;
        int ans = 0;

        for(int i = 0; i < gas.length; i++) {
            remaining_fuel += gas[i] - cost[i];
            if(remaining_fuel < 0) {
                ans = i + 1;
                remaining_fuel = 0;
            }
        }

        return ans;
    }
}