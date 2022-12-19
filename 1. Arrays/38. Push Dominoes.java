// https://leetcode.com/problems/push-dominoes/description/

// TC - O(n) 
// SC = O(N)

class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = new char[n + 2];
        arr[0] = 'L';
        arr[n + 1] = 'R';

        for(int i = 1; i < arr.length - 1; i++) {
            arr[i] = dominoes.charAt(i - 1);
        }

        int j = 0, k = 1;

        while(k < arr.length) {
            while(arr[k] == '.') 
                k++;
            
            if(k - j > 1) 
                solveConfiguration(arr, j, k);

            j = k; 
            k++;
        }

        StringBuilder res = new StringBuilder();
        for(int i = 1; i < arr.length - 1; i++) {
            res.append(arr[i]);
        }
        
        return res.toString();
    }

    public void solveConfiguration(char[] arr, int i, int j) {
        if(arr[i] == 'L' && arr[j] == 'L') {
            // make all dots as L
            for(int k = i + 1; k < j; k++) {
                arr[k] = 'L';
            }
        }
        else if(arr[i] == 'R' && arr[j] == 'R') {
            // make all dots as R
            for(int k = i + 1; k < j; k++) {
                arr[k] = 'R';
            }
        }
        else if(arr[i] == 'L' && arr[j] == 'R') {
            // nothing to do
        }
        else {
            // solve according to odd count and even count of dots
            int diff = j - i;
            int mid = (i + j) / 2;
            if(diff % 2 == 0) {
                // odd dots
                for(int k = i + 1; k < mid; k++) {
                    arr[k] = 'R';
                }
                for(int k = mid + 1; k < j; k++) {
                    arr[k] = 'L';
                }
            }
            else {
                // even dots
                for(int k = i + 1; k <= mid; k++) {
                    arr[k] = 'R';
                }
                for(int k = mid + 1; k < j; k++) {
                    arr[k] = 'L';
                }
            }
        }
    }
}