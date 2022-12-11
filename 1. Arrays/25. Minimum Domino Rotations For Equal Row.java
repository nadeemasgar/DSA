// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans1 = conversionToTarget(tops, bottoms, tops[0]);
        int ans2 = conversionToTarget(tops, bottoms, bottoms[0]);

        if(ans1 > 0 && ans2 > 0) {
            return Math.min(ans1, ans2);
        }
        else if(ans1 > 0) {
            return ans1;
        }
        else return ans2;
    }

    public int conversionToTarget(int[] tops, int[] bottoms, int target) {
        int topConversion = 0;
        int bottomConversion = 0;

        for(int i = 0; i < tops.length; i++) {

           if(tops[i] != target && bottoms[i] != target) {
               return -1;
           }
           else if(tops[i] != target && bottoms[i] == target) {
               topConversion++;
           }
           else if(bottoms[i] != target && tops[i] == target) {
               bottomConversion++;
           }
        }

        return Math.min(topConversion, bottomConversion);
    }
}