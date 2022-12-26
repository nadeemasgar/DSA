// https://leetcode.com/problems/maximum-swap/

import java.util.Arrays;

// TC - O(N)
// SC - O(N)

class Solution {
    public int maximumSwap(int num) {
        String s = "" + num;
        char[] ch = s.toCharArray();

        int[] leftMaxIdx = new int[ch.length];
        // Store Max rightmost index
        for(int i = ch.length - 1; i >= 0; i--) {
            if(i == ch.length - 1) {
                leftMaxIdx[i] = i;
            }
            else {
                if(ch[i] > ch[leftMaxIdx[i + 1]]) {
                    leftMaxIdx[i] = i;
                }
                else {
                    leftMaxIdx[i] = leftMaxIdx[i + 1];
                }
            }
        }
        
        for(int i = 0; i < ch.length - 1; i++) {
            if(ch[i] < ch[leftMaxIdx[i]]) {
                swap(ch, i, leftMaxIdx[i]);
                break;
            }
        }

        return Integer.valueOf(String.valueOf(ch));
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Time - o(n) Space - o(1)

class Solution2 {
    public int maximumSwap(int num) {
        String str = num + "";
        char[] arr = str.toCharArray();

        // 1. prepare last index of digit
        int[] li = new int[10];

        for(int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            li[digit] = i;
        }

        // 2. Figure out position for the swapping
        boolean flag = false;
        for(int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            for(int j = 9; j > digit; j--) {
                if(i < li[j]) {
                    // swapping and break
                    swap(arr, i, li[j]);
                    flag = true;
                    break;
                }
            }

            if(flag == true)
                break;
        }

        /// 3. Prepare answer in form of string
        String res = "";
        for(char ch : arr) {
            res += ch;
        }

        return Integer.parseInt(res);
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
}