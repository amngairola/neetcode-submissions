class Solution {
    class Pair {
        int r;
        int c;
        int t;

        Pair(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.t - b.t);

        pq.offer(new Pair(0, 0, grid[0][0]));
       

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (vis[p.r][p.c]) {
                continue;
            };

            vis[p.r][p.c] = true;

            if (p.r == n - 1 && p.c == m - 1)
                return p.t;

            for (int[] d : dir) {
                int r = p.r + d[0];
                int c = p.c + d[1];

                if (r < 0 || c < 0 || r >= n || c >= m)
                    continue;

                if (vis[r][c])
                    continue;

                int newT = Math.max(p.t, grid[r][c]);
                pq.offer(new Pair(r, c, newT));
            }
        }

        return -1;
    }
}
