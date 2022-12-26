// https://leetcode.com/problems/multiply-strings/description/

// The below solution is wrong as sum can exceed the size of integer

// TC - O(M * N)
// SC - O(1)

class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int sum = 0;

        int multiplier = 1;

        for(int i = m - 1; i >= 0; i--) {
            int k = 1;
            int ch1 = num2.charAt(i) - '0';
            for(int j = n - 1; j >= 0; j--) {
                int ch2 =  (num1.charAt(j) - '0') * k * multiplier;
                int prod = ch1 * ch2;
                sum += prod;    
                k *= 10;
            }
            System.out.println(sum);
            multiplier *= 10;
        }

        
        return "" + sum;
    }
}

// Most understanding solution
// TC - O(M * N)
// SC - O(M + N)

class Solution2 {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            int ch1 = num2.charAt(i) - '0';
            for(int j = n - 1; j >= 0; j--) {
                int ch2 =  (num1.charAt(j) - '0');
                int mul = ch1 * ch2;
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10; 

            }
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        // Managing leading zeros
        for(int p : pos) {
            if(flag == false && p == 0) {
                continue; // leading zeros
            } 
            else {
                flag = true;
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}