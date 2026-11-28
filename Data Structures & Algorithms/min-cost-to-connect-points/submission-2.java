class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int findP(int x) {
            if (parent[x] != x) {
                return parent[x] = findP(parent[x]);
            }

            return x;
        }

        void union(int x, int y) {
            int px = findP(x);
            int py = findP(y);
            if (px == py)
                return;

            if (rank[py] > rank[px]) {
                parent[px] = py;
                rank[py] += rank[px];
            } else {
                parent[py] = px;
                rank[px] += rank[py];
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] x = points[i];
                int[] y = points[j];

                int d = Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);

                pq.add(new int[] {i, j, d});
            }
        }

        DSU d = new DSU(points.length);
        int totel = 0;
       int edgesUsed = 0;

        while (!pq.isEmpty() && edgesUsed < points.length - 1) {
            int[] cur = pq.poll();

            int x = cur[0];
            int y = cur[1];

            if (d.findP(x) != d.findP(y)) {
                d.union(x, y);
                totel += cur[2];
            }
        }

        return totel;
    }
}
