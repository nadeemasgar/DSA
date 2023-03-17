// https://practice.geeksforgeeks.org/problems/graph-and-vertices/1

class Solution {
    static long count(int n) {
        
        int power = n*(n - 1)/2;
        long ans = (long)Math.pow(2, power);
        
        return ans;
  }
}
