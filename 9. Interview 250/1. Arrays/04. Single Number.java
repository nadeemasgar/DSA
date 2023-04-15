// https://leetcode.com/problems/single-number/description/

import java.util.*;

class Solution1 {
    public int singleNumber(int[] nums) {
      List<Integer> no_duplicate_list = new ArrayList<>();
  
      for (int i : nums) {
        if (!no_duplicate_list.contains(i)) {
          no_duplicate_list.add(i);
        } else {
          no_duplicate_list.remove(new Integer(i));
        }
      }
      return no_duplicate_list.get(0);
    }
  }

  class Solution2 {
    public int singleNumber(int[] nums) {
      HashMap<Integer, Integer> hash_table = new HashMap<>();
  
      for (int i : nums) {
        hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
      }
      for (int i : nums) {
        if (hash_table.get(i) == 1) {
          return i;
        }
      }
      return 0;
    }
  }

  class Solution3 {
    public int singleNumber(int[] nums) {
      int a = 0;
      for (int i : nums) {
        a ^= i;
      }
      return a;
    }
  }