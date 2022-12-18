// https://leetcode.com/problems/boats-to-save-people/description/

// Time - o(nlogn) Space - o(1)
import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;

        int i = 0, j = people.length - 1;

        while(i <= j) {
            if (people[i] + people[j] <= limit) {
                count++;
                i++;
                j--;
            }
            else if(people[j] <= limit) {
                count++;
                j--;
            }
            else if(people[i] <= limit) {
                count++;
                i++;
            }
        }

        return count;
    }
}