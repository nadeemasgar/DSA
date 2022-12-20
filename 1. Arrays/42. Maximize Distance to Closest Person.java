// https://leetcode.com/problems/maximize-distance-to-closest-person/description/

// Using BFS
// TC - O(n)
// SC - O(n)

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    public class Pair {
        int idx, dist;
        Pair(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        Queue<Pair> que = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            if(seats[i] == 1)
                que.add(new Pair(i, 0));
        }

        int maxDistance = 0;

        while(que.size() > 0) {
            Pair rp = que.remove();
            int idx = rp.idx;
            int dist = rp.dist;

            if(idx - 1 >= 0 && seats[idx - 1] == 0) {
                que.add(new Pair(idx - 1, dist + 1));
                seats[idx - 1] = 1;
            }

            if(idx + 1 < n && seats[idx + 1] == 0) {
                que.add(new Pair(idx + 1, dist + 1));
                seats[idx + 1] = 1;
            }

            maxDistance = Math.max(maxDistance, dist);
        }

        return maxDistance;
    }
}

// TC - O(n)
// SC - O(1)

class Solution2 {
    // case 1 - Find distance b/w 2 people
    // case 2 - Find the distance when extreme left is empty
    // case 3 - Find the distance when extreme right is empty

    public int maxDistToClosest(int[] seats) {
        int l = -1, n = seats.length, maxDist = 0;
        for(int i = 0; i < n; i++) {
            if(seats[i] == 1) {
                if(l == -1) {   // case 2
                    maxDist = i;
                }
                else { // case 1
                    maxDist = Math.max(maxDist, (i - l) / 2);
                }

                l = i;
            }
        }

        if(seats[n - 1] == 0) {     // case 3
            maxDist = Math.max(maxDist, n - 1 - l);
        }

        return maxDist;
    }
}