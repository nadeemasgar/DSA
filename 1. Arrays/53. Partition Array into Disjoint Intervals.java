// https://leetcode.com/problems/partition-array-into-disjoint-intervals/description/

// TC - O(n)
// SC - O(n)

class Solution {
    // Chaining Techique (Maximum Impact)
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        // 1. Make a rightMin array
        int[] rightMin = new int[n + 1];

        rightMin[n] = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        } 

        // 2. Maintain LeftMax and figureout the partition index
        int leftMax = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            if(leftMax <= rightMin[i + 1]) {
                ans = i + 1;
                break;
            }
        }

        return ans;
    }
}