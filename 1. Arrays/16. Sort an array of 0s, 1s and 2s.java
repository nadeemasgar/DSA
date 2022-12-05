// https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1

class Solution
{
    public static void sort012(int nums[], int n)
    {
        int i = 0, j = 0, k = n - 1;
        
        while(j <= k) {
            if(nums[j] == 0) {
              swap(nums, i, j);
              i++; 
              j++;
            }
            else if(nums[j] == 1) {
                j++;
            }
            else {
                swap(nums, j, k);
                k--;
            }
        }
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}