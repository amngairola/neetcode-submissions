class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        return numIslands(grid);
    }
    static int area;
    static int maxi;

    public int numIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    area = 1;
                    dfs(i, j, grid, vis);
                    maxi = Math.max(maxi, area);
                }
            }
        }

        return maxi;
    }

    void dfs(int i, int j, int[][] arr, boolean[][] vis ) {
        vis[i][j] = true;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int k = 0; k < 4; k++) {
            int r = i + dir[k][0];
            int c = j + dir[k][1];

            if (r < 0 || r >= arr.length || c < 0 || c >= arr[0].length)
                continue;

            else if (arr[r][c] == 1 && !vis[r][c]) {
                area++;
                dfs(r, c, arr, vis);
            }
        }
    }
}
