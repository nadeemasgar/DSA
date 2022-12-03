class Solution {
    public int countAllSubarray(int[] nums) {
        int count = 0, countSubaray = 0, n = nums.length;
        
        for(int num : nums) {
            count = count + 1;
            countSubaray += count;
        }
        
        int countSubarayFormula = (n * (n + 1)) / 2; // Formula - (n * (n + 1)) / 2;
        System.out.println(countSubarayFormula);
        
        return countSubaray;
    }
}