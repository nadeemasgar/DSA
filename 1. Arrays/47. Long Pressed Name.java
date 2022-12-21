// https://leetcode.com/problems/long-pressed-name/

// TC - O(n)
// SC - O(1)

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length())
            return false;

        int i = 0; // iterating over name
        int j = 0; // iterating over typed

        while(i < name.length() && j < typed.length()) {
            char ch1 = name.charAt(i);
            char ch2 = typed.charAt(j);

            if(ch1 == ch2) { // name & typed character is same
                i++;
                j++;
            }
            else if(j > 0 && ch2 == typed.charAt(j - 1)) { // if not same then it should be same with prev char
                j++;
            }
            else {
                return false;
            }
        }

        if(i != name.length()) // name should exhaust
            return false;

        while(j < typed.length()) { // typed rest of character should be same as previous
            if(typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
            j++;
        }
       
        return true;
    }
}