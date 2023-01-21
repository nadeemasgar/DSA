// https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/

// Length of the largest subarray with contiguous elements

// TC - O(n^2)
// SC - O(n)

import java.util.*;

class Solution
{
    public static int solution(int nums[])
    {
        int maxLen = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            int min = nums[i];
            int max = nums[i];
            HashSet<Integer> set = new HashSet<>();
            set.add(nums[i]);

            for(int j = i + 1; j < nums.length; j++) {
                if(set.contains(nums[j])) {
                    break;
                }
                set.add(nums[j]);

                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                if(max - min == j - i) {
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }
}