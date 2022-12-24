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


// Code with Comments (during revison)

class Solution2 {
    public int nextGreaterElement(int n) {
        String s = "" + n;
        char[] ch = s.toCharArray();

        int i = ch.length - 2;

        // Checking for first decreasing number from back.
        while(i >= 0) {
            int ele1 = ch[i + 1] - '0';
            int ele2 = ch[i] - '0';

            if(ele1 <= ele2) {
                i--;
            }
            else{
                break;
            }
        }
         
        if(i == -1) return -1; // Not possible. Ex - 654321, 654421 
        // Number is constantly decreasing from starting so no greater number possible

        int swapIndex1 = i;
        int j = ch.length - 1;

        // Finding just greater element from arr[swapIndex1]
        while(j >= 0) {
            if(ch[swapIndex1] - '0' < ch[j] - '0') {
                break;
            }
            j--;
        }

        int swapIndex2 = j;
        swap(ch, swapIndex1, swapIndex2);
        // put the rest of number in increasing order
        reverse(ch, swapIndex1 + 1, ch.length - 1);

        String ans = new String(ch);

        try {
            return Integer.parseInt(ans);
        }
        catch (Exception e) {
            return -1;
        }
    }

    public void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public void reverse(char[] ch, int i, int j) {
        while(i < j) {
            swap(ch, i, j);
            i++;
            j--;
        }
    }
}