// https://leetcode.com/problems/sort-colors/description/

class Solution {
    public void sortColors(int[] nums) {
        int pt1 = 0;
        int pt2 = 0;
        int pt3 = nums.length - 1;
        
        while(pt2 <= pt3) {
            if(nums[pt2] == 0) {
                swap(nums, pt1, pt2);
                pt1++;
                pt2++;
            }
            else if(nums[pt2] == 1) {
                pt2++;
            }
            else if(nums[pt2] == 2){
                swap(nums, pt2, pt3);
                pt3--;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}