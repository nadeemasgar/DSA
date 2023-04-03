// https://leetcode.com/problems/subsets-ii/description/

// TC- O(2^N)
// SC- O(2^N)

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }

    public void findSubsets(int idx, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for(int i = idx; i < nums.length; i++) {
            if(i != idx && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            findSubsets(i + 1, nums, ds, ansList);
            ds.remove(ds.size() - 1);
        }
    }
}