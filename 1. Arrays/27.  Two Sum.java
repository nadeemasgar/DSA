// https://leetcode.com/problems/two-sum/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int ele = nums[i];

            if(map.containsKey(target - ele )) {
                int idx = map.get(target - ele);
                return new int[]{idx, i};
            }
            else {
                map.put(ele, i);
            }
        }

        return new int[2];
    }
}