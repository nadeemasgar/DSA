// https://www.geeksforgeeks.org/check-if-frequency-of-all-characters-can-become-same-by-one-removal/

// TC - O(n) assuming alphabet size is constant. 
// SC - O(1)

class Solution {
    
    int getIdxChar(char ch) {
        return ch - 'a';
    }
    
    boolean allSame(int[] freq) {
        int same = 0;
        int i = 0;
        while(i < freq.length) {
            if(same == 0 && freq[i] > 0) {
                same = freq[i];
            }
            else if(freq[i] > 0 && freq[i] != same){
                return false;
            }
            
            i++;
        }
        
        return true;
    }
    
    boolean sameFreq(String s) {
        int[] freq = new int[26];
        // storing the frequencies of string
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[getIdxChar(ch)]++;
        }
        
        if(allSame(freq)) {
            return true;
        }
        
        /* Decreasing frequency of all character by one 
            and then check equality of frequencies */
        for (char c = 'a'; c <= 'z'; c++) {
            int i = getIdxChar(c);
 
            // Check character only if it occurs in str
            if (freq[i] > 0) {
                freq[i]--;
 
                if (allSame(freq))
                    return true;
                freq[i]++;
            }
        }
 
        return false;
    }
}