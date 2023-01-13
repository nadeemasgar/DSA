// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/

// TC - O(N log^2 N)
// SC - O(N)

import java.util.*;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val:deck){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        int ans = 0;

        for(int key: map.keySet()) {
            ans = getGCD(ans, map.get(key));
        }

        return ans >= 2;
    }

    public int getGCD(int n1, int n2){
        while(n1 % n2 != 0){
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        return n2;
    }

    /* public int getGCD(int a, int b){
        if(b==0){
            return a ;
        }
        return gcd(b, a%b);
    } */
}