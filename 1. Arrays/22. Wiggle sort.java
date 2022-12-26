// https://leetcode.com/problems/wiggle-sort/description/

import java.util.Arrays;

// Time - o(nLogn) space - o(n)

class Solution1 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if(nums.length <= 2) return;
        int i = 1, j = i + 1;
        while(j < nums.length) {
            swap(nums, i, j);
            i += 2;
            j += 2;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Solution2 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if(n == 1) return;
        Arrays.sort(nums);
        int[] res = new int[n+1];
        int i = 0, j = n - 1, k = 0;

        while(i <= j) {
            int ele1 = nums[i];
            int ele2 = nums[j];
        
            res[k] = ele1;
            res[k+1] = ele2;

            k += 2;
            i++;
            j--;
        }

        for(i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }
}

// Time - o(n) space - o(1)

class Solution3 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            if(i % 2 == 0) {
                if(nums[i + 1] < nums[i]) {
                    swap(nums, i, i + 1);
                }
            }
            else {
                if(nums[i + 1] > nums[i]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}