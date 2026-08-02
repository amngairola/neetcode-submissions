class Solution {
    public int countComponents(int x, int[][] grid) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < grid.length; i++) {
            int u = grid[i][0];
            int v = grid[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        int n = grid.length;
        int m = grid[0].length;
        boolean[] vis = new boolean[x];

        int cnt = 0;
        for (int i = 0; i < x; i++) {
            if (!vis[i]) {
                    dfs(i, adj, vis);
                    cnt++;
                }
            
        }

        return cnt;
    }

    void dfs(int j,  ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[j] = true;

        for (int node : adj.get(j)) {
             if (!vis[node]) {
                dfs(node, adj, vis);
            }
        }
    }
}
