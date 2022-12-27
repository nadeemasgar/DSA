// https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

import java.util.*;

// TC - O(n log*k)
// SC - O(k)

class Solution {
    public int findKthLargest(int[] arr, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;

        while(k-- > 0) {
            pq.add(arr[i]);   
            i++;
        }

        while(i < arr.length) {
            int val = pq.peek();

            if(val < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
            i++;
        }
        
        return pq.remove();
    }
}


// Quick Select
// Best TC - O(n), Worst TC - O(n^2)
// SC - O(1)

class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // kth largest is (N - k)th smallest (k should be mentioned from 0th-Indexing)
        return quickSelect(nums, 0, nums.length - 1, n - k);
    }

    public int quickSelect(int[] nums, int lo, int hi, int k) {

        int pivot = nums[hi];
        int pi = partition(nums, pivot, lo, hi);
        if (pi > k){
            return quickSelect(nums, lo, pi - 1, k);
        }
        else if (pi < k){
            return quickSelect(nums, pi + 1, hi, k);
        }
        return pivot;
    }

    public int partition(int[] nums, int pivot, int lo, int hi) {
        int i = lo, j = lo;
        while (i <= hi) {
            if (nums[i] <= pivot) {
                swap(nums, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
   
        return (j - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}