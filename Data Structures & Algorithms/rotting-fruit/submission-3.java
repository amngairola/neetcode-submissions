class Solution {
    class Pair {
        int r;
        int c;
        int time;

        Pair(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        
        int m = grid[0].length;
        

        Queue<Pair> q = new LinkedList<>();
        int cntFresh = 0;
         int cntE = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                }
                if (grid[i][j] == 1) {
                    cntFresh++;
                }else {
                    cntE++;
                }
            }
        }

        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        int processFresh = 0;
        int time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int x = 0; x < size; x++) {
                Pair node = q.poll();
               

                for (int i = 0; i < 4; i++) {
                    int r = node.r + dir[i][0];
                    int c = node.c + dir[i][1];

                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
                        continue;
                    }
                    if ( grid[r][c] ==  1 && !vis[r][c])  {
                        processFresh++;
                    } 
                     if (grid[r][c] == 1 && dist[r][c] > node.time + 1) {
                        dist[r][c] = node.time + 1;
                        q.offer(new Pair(r, c, node.time + 1));
                        vis[r][c] = true;
                    }
                }
            }
        }

        if(cntE == n * m) return 0;
        return processFresh != cntFresh ? -1 : time;
    }
}
