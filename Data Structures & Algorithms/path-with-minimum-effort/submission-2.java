
class Solution {

    class Pair {
        int r;
        int c;
        int effort;

        Pair(int r, int c, int effort) {
            this.r = r;
            this.c = c;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] h) {

        int n = h.length;
        int m = h[0].length;

        int[][] efforts = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(efforts[i], (int) 1e9);
        }

        PriorityQueue<Pair> q = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.effort, b.effort)
        );

        efforts[0][0] = 0;
        q.offer(new Pair(0, 0, 0));

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            int currentEffort = cur.effort;

            // Ignore outdated entry
            if (currentEffort > efforts[cur.r][cur.c])
                continue;

            // Destination reached
            if (cur.r == n - 1 && cur.c == m - 1)
                return currentEffort;

            for (int[] d : dir) {

                int r = cur.r + d[0];
                int c = cur.c + d[1];

                if (r < 0 || c < 0 || r >= n || c >= m)
                    continue;

                int diff = Math.abs(
                    h[cur.r][cur.c] - h[r][c]
                );

                // Maximum effort along this path
                int newEff = Math.max(currentEffort, diff);

                if (efforts[r][c] > newEff) {

                    efforts[r][c] = newEff;

                    q.offer(
                        new Pair(r, c, newEff)
                    );
                }
            }
        }

        return 0;
    }
}

