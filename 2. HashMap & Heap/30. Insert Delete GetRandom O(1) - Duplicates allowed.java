// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class RandomizedCollection {
    HashMap<Integer, HashSet<Integer>> map;
    List<Integer> list;
    Random r;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        boolean flag;
        HashSet<Integer> set;
        if(map.containsKey(val) == true) {
            set = map.get(val);
            flag = false;
        }
        else {
            set = new HashSet<>();
            flag = true;
        }

        set.add(list.size());
        list.add(val);
        map.put(val, set);

        return flag;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val) == false) return false;

        HashSet<Integer> set = map.get(val);

        int remIdx = -1;
        for(int i : set) {
            remIdx = i;
            break;
        }

        set.remove(remIdx);
        map.put(val, set);
        if(map.get(val).size() == 0) {
            map.remove(val);
        }

        if(remIdx == list.size() - 1) {
            list.remove(list.size() - 1);
        }
        else {
            int lastEle = list.get(list.size() - 1);
            list.set(remIdx, lastEle);
            list.remove(list.size() - 1);

            int newVal = list.get(remIdx);
            HashSet<Integer> temp = map.get(newVal);
            temp.remove(list.size());
            temp.add(remIdx);
            map.put(newVal, temp);
        }

        return true;
    }
    
    public int getRandom() {
        int randomIdx = r.nextInt(list.size());
        return list.get(randomIdx);
    }
}