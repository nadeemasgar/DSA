// Bulb switcher
// https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/

class Solution {
    public int numTimesAllBlue(int[] light) {
        int n = light.length;
        
        int chunk = 0, sum1 = 0, sum2 = 0;
        
        for(int i = 0; i < n; i++)
        {
            sum1 += light[i] - 1;
            sum2 += i;
            
            if(sum1 == sum2)
                chunk++;
        }
        return chunk;
    }
}


class Solution2 {
    public int numTimesAllBlue(int[] light) {
        int n = light.length;
        int max = 0, count = 0;
        
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, light[i]);
            
            if(max == i + 1)
                count++;
        }
        
        return count;
    }
}