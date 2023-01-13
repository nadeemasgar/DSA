// https://leetcode.com/problems/k-closest-points-to-origin/description/

import java.util.*;

// TC - O(NlogK)
// SC - O(K)

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for(int[] p : points) {
            pq.add(p);
            if(pq.size() > k) {
                pq.remove();
            }
        }

        int i = 0;
        int[][] ans = new int[k][2];
        while(pq.size() > 0) {
            ans[i++] = pq.remove();
        }

        return ans;
    }
}

// Avg TC - O(n)
// Worse TC - O(n^2)
// SC - O(1)

class Solution2 {
    public int[][] kClosest(int[][] points, int K) {
        Collections.shuffle(Arrays.asList(points)); // For randomizing array
        int i = 0, j = points.length - 1;
        while(i < j) {
            int mid = partition(points, i, j);
            if(mid == K) break;
            if(mid < K) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K); // return Arrays.copyOf(points, K);
    }
    
    private int partition(int[][] points, int start, int end) {
        int[] pivot = points[end];
        int swapIndex = start - 1;
        for(int i = start; i < end; i++) {
            if(value(points[i]) < value(pivot)) {
                swapIndex++;
                swap(points, swapIndex, i);
            }
        }
        swap(points, ++swapIndex, end);
        return swapIndex;
    }
    
    private int value(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}