// https://leetcode.com/problems/combination-sum-ii/description/

// TC - O(2^t) exponential
// SC - o(N)

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    public void findCombinations(int idx, int[] arr, int target, List<Integer> ds, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx; i < arr.length; i++) {
            if(i > idx && arr[i] == arr[i - 1]) continue;

            ds.add(arr[i]);
            findCombinations(i+1, arr, target - arr[i], ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}