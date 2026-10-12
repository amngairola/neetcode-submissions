
class Dsu {
    int[] parent;
    int[] rank;

    Dsu(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 1);
    }

    int findP(int x) {
        if (parent[x] != x)
            parent[x] = findP(parent[x]);

        return parent[x];
    }

    boolean union(int x, int y) {
        int px = findP(x);
        int py = findP(y);

        if (py == px)
            return false;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] p) {
        int n = p.length;

        List<int[]> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = p[i][0];
                int x2 = p[i][1];
                int y1 = p[j][0];
                int y2 = p[j][1];

                int d = Math.abs(x1 - y1) + Math.abs(x2 - y2);

                adj.add(new int[] {d, i, j});
            }
        }
        adj.sort((a, b) -> Integer.compare(a[0], b[0]));

        int res = 0;
        Dsu dsu = new Dsu(n);
        for (int[] edg : adj) {
            if (dsu.union(edg[1], edg[2]))
                res += edg[0];
        }

        return res;
    }
}
