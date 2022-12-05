// https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/

class Solution {
    static boolean areRotations(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        else {
            String temp = s1 + s2;
            return temp.indexOf(s2) != -1;
        }
    }
}