// https://leetcode.com/problems/distant-barcodes/description/

// TC - O(N log(N))
// SC - O(N)

import java.util.*;

class Solution {
    public static class Pair {
        int num;
        int freq;

        Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        //create a hashmap 
	    HashMap<Integer,Integer> map = new HashMap<>();
	    for(int i = 0; i < barcodes.length; i++){
	        map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
	    }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> b.freq - a.freq); // MAX_HEAP
        for(Integer key: map.keySet()){
	        pq.add(new Pair(key, map.get(key)));
	    }

        int[] ans = new int[barcodes.length];
        int ptr = 0;

        Pair block = pq.remove();
        ans[ptr] = block.num;
        ptr++;
        block.freq--;

        while(pq.size() > 0) {
            Pair temp = pq.remove();
            ans[ptr] = temp.num;
            ptr++;
            temp.freq--;
            if(block.freq > 0) {
                pq.add(block);
            }
            block = temp;
        }

        return ans;
    }
}