// https://leetcode.com/problems/bulb-switcher/description/

// TC - O(sqrt(n))
// SC - O(1)

class Solution {
    public int bulbSwitch(int n) {
        int count = 0;
        for(int i = 1; i * i <= n; i++) {
            count++;
        }
        
        return count;
    }

    // return (int)Math.sqrt(n);
}