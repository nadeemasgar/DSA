// Disjoint Set | Union by Rank | Union by Size | Path Compression

// TC - O(V + E)

class Solution {
    static int[] par, size;

    public static int findPar(int u) {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }

    public static void unionBySize(int p1, int p2) {
        if(size[p1] < size[p2]) {
            par[p1] = p2;
            size[p2] += size[p1];
        }
        else {
            par[p2] = p1;
            size[p1] = size[p2];
        }
    }

    public static void unionFind(int[][] Edges, int N) {
        par = new int[N];
        size = new int[N];

        for(int i = 0; i < N; i++) {
            par[i] = i;
            size[i] = 1;
        }

        for(int[] e: Edges) {
            int u = e[0];
            int v = e[1];

            int p1 = findPar(u);
            int p2 = findPar(v);

            if(p1 != p2) {
                unionBySize(p1, p2);
            }
        }
    }
}