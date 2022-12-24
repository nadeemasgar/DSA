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
        int count1 = count(nums, right); // Number of Subarrays smaller or equal to right
        int count2 = count(nums, left - 1); // Number of Subarrays smaller or equal to (left - 1)
        return count1 - count2;
    }
    
    int count(int[] nums,int right){
        int s = 0, e = 0;
        int ans = 0;
        for(e = 0; e < nums.length; e++){
            if(nums[e] > right){
                s = e + 1;
            }
            else{
                ans += e - s + 1;            
            }
        }

        return ans;
    }
}

// Time - O(N) Way 2

class Solution3 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int i = 0, j = 0;
        int smaller = 0, ans = 0;

        for(i = 0; i < nums.length; i++) {
            if(nums[i] >= left && nums[i] <= right) {
                smaller = i - j + 1;
                ans += smaller;
            }
            else if(nums[i] < left) {
                ans += smaller;
            }
            else if(nums[i] > right) {
                smaller = 0;
                j = i + 1;
            }
        }

        return ans;
    }
}