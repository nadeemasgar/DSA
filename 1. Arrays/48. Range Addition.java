// https://leetcode.com/problems/range-addition/

// TC - O(n * k)
// SC - O(1)

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];

        for(int[] update: updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];

            while(start <= end) {
                arr[start] +=  inc;
                start++;
            }
        }

        return arr;
    }
}

// TC - O(n + k)
// SC - O(1)

class Solution2 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];

            res[start] += inc;
            if(end + 1 < length) {
                res[end + 1] -= inc;
            }
        }

        int prefixSum = 0;
        for(int i = 0; i < length; i++) {
            prefixSum += res[i];
            res[i] = prefixSum;
        }

        return res;
    }
}