// https://leetcode.com/problems/next-greater-element-iii/

class Solution {
    public int nextGreaterElement(int n) {
        char[] ch = ("" + n).toCharArray();
        int i = ch.length - 2;
        
        while(i >= 0 && ch[i] >= ch[i + 1]) {
            i--;
        }
        
        if(i < 0)
            return -1;
        
        int j = ch.length - 1;
        
        while(j >= 0 && ch[j] <= ch[i]) {
            j--;
        }
        
        swap(ch, i, j);
        reverse(ch, i + 1);
        
        try {
            return Integer.parseInt(new String(ch));
        }
        catch(Exception e) {
            return -1;   
        }
    }
    
    public void swap(char[] ch, int a, int b) {
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;
    }
    
    public void reverse(char[] ch, int start) {
        int i = start, j = ch.length - 1;
        
        while(i < j) {
            swap(ch, i, j);
            i++;
            j--;
        }
    }
}