// https://leetcode.com/problems/find-anagram-mappings/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                ArrayList<Integer> list = map.get(nums2[i]);
                list.add(i);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums2[i], list);
            }
        }

        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            ArrayList<Integer> list = map.get(nums1[i]);
            ans[i] = list.remove(list.size() - 1);
        }

        return ans;
    }
}