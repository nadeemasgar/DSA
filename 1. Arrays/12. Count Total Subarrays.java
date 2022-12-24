class Solution {
    public int maxSubArray(int[] nums) {
        int count = 0, countSubaray = 0, n = nums.length;
        
        for(int num : nums) {
            count = count + 1;
            countSubaray += count;
            System.out.println("count " + count + " countSubaray " + countSubaray);
        }
        
        int countSubarayFormula = (n * (n + 1)) / 2; // Formula - (n * (n + 1)) / 2;
        System.out.println("countSubaray " + countSubaray + " countSubarayFormula " + countSubarayFormula);
        
        return countSubaray;
    }
}

/* 
=> nums = [2,1,3,4,1,2,1,5,4]

=> Stdout
count 1 countSubaray 1
count 2 countSubaray 3
count 3 countSubaray 6
count 4 countSubaray 10
count 5 countSubaray 15
count 6 countSubaray 21
count 7 countSubaray 28
count 8 countSubaray 36
count 9 countSubaray 45
countSubaray 45 countSubarayFormula 45
*/


// More easy to understand

class Solution2 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int countSubaray = 0, n = nums.length, j = 0;
        
        for(int i = 0; i < nums.length; i++) {
            countSubaray += i - j + 1; // Loop Formula
        }
        
        int countSubarayFormula = (n * (n + 1)) / 2; // Formula - (n * (n + 1)) / 2;
        System.out.println("countSubaray " + countSubaray + " countSubarayFormula " + countSubarayFormula);
        
        return countSubaray;
    }
}