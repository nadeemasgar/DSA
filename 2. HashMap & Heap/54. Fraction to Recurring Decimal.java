// https://leetcode.com/problems/fraction-to-recurring-decimal/description/
// https://practice.geeksforgeeks.org/problems/a-simple-fraction0921/1

import java.util.*;


class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        String ans = "";
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            ans += "-";
        }
        
        HashMap<Long, Integer> map = new HashMap<>(); // remainder freq
        
        // Convert to Long or else abs(-2147483648) overflows
        long nume = Math.abs(Long.valueOf(numerator));
        long deno = Math.abs(Long.valueOf(denominator));

        long quo = nume / deno;
        long rem = nume % deno;
        
        ans += quo;
        nume = rem;
        
        if(nume == 0) {
            return ans;
        }
        
        String frac = "";
        while(nume != 0 && map.containsKey(nume) == false) {
            map.put(nume, frac.length());
            
            nume *= 10;
            quo = nume / deno;
            rem = nume % deno;
            
            frac += quo;
            nume = rem;
        }
        
        if(nume == 0) {
            return ans + "." + frac;
        }
        else {
            int idx = map.get(nume);
            frac = frac.substring(0, idx) + "(" + frac.substring(idx) + ")";
            
            return ans + "." + frac; 
        }
    }
}