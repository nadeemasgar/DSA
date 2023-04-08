// https://leetcode.com/problems/permutations/description/

// TC - O(n! * n)
// SC - O(n)

import java.util.*;

class Solution1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recurPermute(nums, ds, ans, freq);
        return ans;
    }

    public void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        if(ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                recurPermute(nums, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}


// Approach 2 - Using swappings for space optimization

class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }

    public void recurPermute(int idx, int[] nums, List<List<Integer>> ans) {
        if(idx == nums.length) {
            // copy the ds to ans
            List<Integer> ds = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }

            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            swap(i, idx, nums);
            recurPermute(idx + 1, nums, ans);
            swap(i, idx, nums);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
}
