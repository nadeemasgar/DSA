// https://leetcode.com/problems/accounts-merge/description/

import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU ds = new DSU(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if(mapMailNode.containsKey(mail) == false) {
                    mapMailNode.put(mail, i);
                }
                else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergeMail = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            mergeMail[i] = new ArrayList<>();
        }

        for(Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findPar(it.getValue());
            mergeMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(mergeMail[i].size() == 0) continue;
            Collections.sort(mergeMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : mergeMail[i]) {
                temp.add(it);
            }

            ans.add(temp);
        }

        return ans;
    }
}

class DSU {
	int n;
	int par[], size[];
	
	DSU(int n) {
		this.n = n;
		this.par = new int[n];
		this.size = new int[n];
		
		for(int i = 0; i < n; i++) par[i] = i;
	}
	
	int findPar(int node){
		if(par[node] == node)
			return node;
		return par[node] = findPar(par[node]);
	}
	
	boolean unionBySize(int u, int v){
		int p1 = findPar(u);
		int p2 = findPar(v);
		
		if(p1 == p2) return false;
		
		if(size[p1] < size[p2]) {
            par[p1] = p2;
            size[p2] += size[p1];
        }
        else {
            par[p2] = p1;
            size[p1] = size[p2];
        }
        
		return true;
	}
}