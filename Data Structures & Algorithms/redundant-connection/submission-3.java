class Solution {
    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        int findP(int x) {
            if (parent[x] != x)
                parent[x] = findP(parent[x]);

            return parent[x];
        }

        void union(int x, int y) {
            int px = findP(x);
            int py = findP(y);

            if (px == py)
                return;

            if (size[px] < size[py]) {
                parent[px] = py;
            } else if (size[px] > size[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                size[px]++;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int nodes = edges.length + 1;
        DSU dsu = new DSU(nodes);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 1; i <= nodes; i++) {
            adj.add(new ArrayList<>());
        }

        int[] ans = new int[2];

        for (int[] edg : edges) {
            int a = edg[0];
            int b = edg[1];
            if (dsu.findP(a) == dsu.findP(b)) {
                return edg;
            }
            dsu.union(a, b);
        }

        return ans;
    }
}
