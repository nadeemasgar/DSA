// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/arrays-and-strings/sieve-of-eratosthenes/ojquestion

// TC - O(n log (log n))
// SC - O(n)

import java.util.Arrays;

class Solution {
    public static void printPrimeUsingSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        
        Arrays.fill(isPrime, true);
        
        for(int i = 2; i * i <= isPrime.length; i++) {
            if(isPrime[i] == true) {
                // making multiples not prime
                for(int j = i + i; j < isPrime.length; j += i) { // More Optimized - j = i * i
                    isPrime[j] = false; // not prime
                }
            }
        }
        
        // print all prime till n
        for(int i = 2; i < isPrime.length; i++) {
            if(isPrime[i] == true) {
                System.out.print(i + " ");
            }
        }
    }
}