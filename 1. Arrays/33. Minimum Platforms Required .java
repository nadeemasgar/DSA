// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1


import java.util.Arrays;

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arrival[], int departure[], int n)
    {
        Arrays.sort(arrival);
        Arrays.sort(departure);
        
       int i = 0, j = 0;
       int result = 0, platform_needed = 0;
       
       while(i < n && j < n) {
           if(arrival[i] <= departure[j]) {
               platform_needed++;
               i++;
           }
           else {
               platform_needed--;
               j++;
           }
           
           result = Math.max(result, platform_needed);
       }
       
       return result;
    }
}
