// https://leetcode.com/problems/partition-array-according-to-given-pivot/description/

// TC - O(N)
// SC - O(N)

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n =  nums.length;
        int[] ans = new int[n];
        int countPivot = 0, ptr = 0;

        // smaller element filled in ans
        for(int i = 0; i < n; i++) {
            if(nums[i] < pivot) {
                ans[ptr++] = nums[i];
            }
            else if(nums[i] == pivot) {
                countPivot++;
            }
        }

        // Pivot element is filled in ans
        while(countPivot-- > 0) {
            ans[ptr++] = pivot;
        }

        // greater element is filled in ans
        for(int i = 0; i < n; i++) {
            if(nums[i] > pivot) {
                ans[ptr++] = nums[i];
            }
        }

        return ans;

    }
}