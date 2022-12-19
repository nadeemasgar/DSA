// https://leetcode.com/problems/valid-palindrome-ii/

// TC - O(N)
// SC - O(1)

class Solution {
    public boolean validPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while(i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            }
            else {
                return isPalindrome(str, i + 1, j) || isPalindrome(str, i, j - 1);
            }
        }

        return true; 
    }

    public boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else return false;
        }

        return true;
    }
}