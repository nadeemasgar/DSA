// https://leetcode.com/problems/reverse-vowels-of-a-string/

// Time - O(N), Space - O(1)

class Solution {

    boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
            || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }

    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0, j = sb.length() - 1;

        while(i < j) {
            char ch1 = sb.charAt(i), ch2 = sb.charAt(j);
            if(!isVowel(ch1)) {
                i++;
            }
            else if(!isVowel(ch2)) {
                j--;
            }
            else {
               sb.setCharAt(i, ch2);
               sb.setCharAt(j, ch1);
               i++;
               j--;
            }
        }

        return sb.toString();
    }
}