// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/

// TC - O(n)
// SC - O(1)

class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int sum = 0, min = Integer.MAX_VALUE;

        for(int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }

        return sum - n * min;
    }
}