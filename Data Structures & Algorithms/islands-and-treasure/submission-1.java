class Solution {

    class Pair {
        int r;
        int c;
        int dist;

        Pair(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new Pair(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int x = 0; x < size; x++) {
                Pair cur = q.poll();
                

                int[][] dir = {
                    {-1, 0},
                    {1, 0},
                    {0, -1},
                    {0, 1},
                };

                for (int k = 0; k < 4; k++) {
                    int i = cur.r + dir[k][0];
                    int j = cur.c + dir[k][1];
                    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                        continue;
                    }

                    if (grid[i][j] == -1 || grid[i][j] == 0) {
                        continue;
                    }
                    if(grid[i][j] > cur.dist+1){
                        q.offer(new Pair(i , j , cur.dist+1));
                        grid[i][j] = cur.dist +1;
                    }
                }
            }
        }

       
    }
}
