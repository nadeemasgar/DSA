// https://leetcode.com/problems/combination-sum/description/

// TC - O(2^t) exponential
// SC - o(N)

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    public void findCombinations(int idx, int[] arr, int target, List<Integer> ds, List<List<Integer>> ans) {
        if(idx == arr.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[idx] <= target) {
            ds.add(arr[idx]);
            findCombinations(idx, arr, target - arr[idx], ds, ans);
            ds.remove(ds.size() - 1);
        }

        findCombinations(idx + 1, arr, target, ds, ans);
    }
}