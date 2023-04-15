// https://leetcode.com/problems/first-missing-positive/

import java.util.*;

 // TC - O(n)
 // SC - O(n)
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int i = 1;
        while(set.contains(i)) {
            i++;
        }
        return i;
    }
}

class Solution2 {
    // TC - O(3n) ~ O(n)
    // SC - O(1)
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 1. [3, 4, -1, 1]
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // 2. [3, 4, 5, 1]
        for(int i = 0; i < n; i++) {
            int id = Math.abs(nums[i]);
            if(id > n)  continue;
            id--; // 0-index
            if(nums[id] > 0) nums[id] = -nums[id];
        }

        // 3. [-3, 4, -5, -1]
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) 
                return i + 1;
        }

        return n + 1;
    }
}