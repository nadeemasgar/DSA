// https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1

import java.util.*;

class Solution
{
    public boolean findPair(int nums[], int size, int target)
    {
        Arrays.sort(nums);
        int i = 0, j = 1;
        
        while(i < size && j < size) {
            int ele1 = nums[i], ele2 = nums[j];
            
             if (i != j && nums[j] - nums[i] == target) {
                return true;
            }
            else if(ele2 - ele1 < target) {
                j++;
            }
            else {
                i++;
            }
        }
        
        return false;
    }
}