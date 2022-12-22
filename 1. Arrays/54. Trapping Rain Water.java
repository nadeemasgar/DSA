// https://leetcode.com/problems/trapping-rain-water/description/

// Prefix Max & Suffix Max

// TC - O(N)
// SC - O(N)

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                prefixMax[i] = height[0];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
            }
        }

        for(int i = n - 1; i >= 0; i--) {
           if(i == n - 1) {
                suffixMax[i] = height[n - 1];
            }
            else {
                suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
            } 
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            ans += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }

        return ans;
    }
}


// 2 Pointer Approach

// TC - O(N)
// SC - O(1)

class Solution2 {
    public int trap(int[] height) {
        int n = height.length;
        if(n <= 2) {
            return 0;
        }

        int maxLeft = height[0];
        int maxRight = height[n - 1];
        int trappedWater = 0;

        int left = 1; // left pointer
        int right = n - 2; // right pointer
        while(left <= right) {
            if(maxLeft < maxRight) {
                if(height[left] > maxLeft) {
                    maxLeft = height[left];
                }
                else {
                    trappedWater += maxLeft - height[left];
                }

                left++;
            }
            else {
                if(height[right] > maxRight) {
                    maxRight = height[right]; 
                }
                else {
                    trappedWater += maxRight - height[right];
                }

                right--;
            }
        }

        return trappedWater;
    }
}