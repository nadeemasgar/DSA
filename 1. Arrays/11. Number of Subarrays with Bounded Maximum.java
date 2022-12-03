// https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

// Time - O(N^2)

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int max = 0, res = 0;
        
        for(int i = 0; i < nums.length; i++) {
            
            max = 0;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] > max) 
                    max = nums[j];
                
                if(max >= left && max <= right) 
                    res++;
                
                if(max > right) break;
            }
        }
        
        return res;
    }
}

// Time - O(N) Way 1

class Solution2 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }
    
    public int count(int[] nums, int bound) {
        int curr = 0, ans = 0;
        
        for(int num : nums) {
            curr = num <= bound ? curr + 1 : 0; // no. of subarray ending at num
            System.out.println(curr);
            ans += curr;
        }
        
        return ans;
    }
}

// Time - O(N) Way 2

class Solution3 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int i = 0, j = 0, count = 0, res = 0;
        
        while(i < nums.length) {
            if(nums[i] >= left && nums[i] <= right) {
                count = i - j + 1;
                res += count;
            }
            
            if(nums[i] < left) {
                res += count;
            }
            
            if(nums[i] > right) {
                j = i + 1;
                count = 0;
            }
            
            i++;
        }
        
        return res;
    }
}