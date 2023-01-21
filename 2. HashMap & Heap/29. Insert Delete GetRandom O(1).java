// https://leetcode.com/problems/insert-delete-getrandom-o1/description/

// TC - O(1)
// SC - O(1)

import java.util.*;

class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
 
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val) == false) return false;

        // move the last element to the place idx of the element to delete
        int idx = map.get(val);
        int lastEle = list.get(list.size() - 1);
        list.set(idx, lastEle);
        map.put(lastEle, idx);

        // delete the last element
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        int randomIdx = rand.nextInt(list.size());
        return list.get(randomIdx);
    }
}