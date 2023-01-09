// https://www.geeksforgeeks.org/maximum-sum-of-smallest-and-second-smallest-in-an-array/

// Given an array, find maximum sum of smallest and second smallest elements chosen from all possible subarrays.

// An efficient solution is based on the observation that this problem reduces to 
// finding a maximum sum of two consecutive elements in array. 

/* **************************************************************************************************************** */
// Java program to get max sum with smallest
// and second smallest element from any subarray
import java.lang.*;
class num{

// Method returns maximum obtainable sum value
// of smallest and the second smallest value
// taken over all possible subarrays */
    static int pairWithMaxSum(int[] arr, int N)
    {
    if (N < 2)
        return -1;

    // Find two consecutive elements with maximum
    // sum.
    int res = arr[0] + arr[1];
    for (int i=1; i<N-1; i++)
        res = Math.max(res, arr[i] + arr[i+1]);

    return res;
    }

    // Driver program
    public static void main(String[] args)
    {
        int arr[] = {4, 3, 1, 5, 6};
        int N = arr.length;
        System.out.println(pairWithMaxSum(arr, N));
    }
}