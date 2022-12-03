// https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;
        
        for(int num : nums) {
            if(count == 0) {
                candidate = num;
            }
            
            count = candidate == num ? ++count : --count;
        }
        
        return candidate;
    }
}