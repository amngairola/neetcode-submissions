class Solution {
    public int longestIncreasingPath(int[][] mat) {
        int maxi = 0;
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int path = dfs(i, j, mat, dp);
                maxi = Math.max(path, maxi);
            }
        }
        return maxi;
    }

    int dfs(int r, int c, int[][] mat, int[][] dp) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int curPath = 0;

        for (int[] dir : dirs) {
            int i = r + dir[0];
            int j = c + dir[1];

            if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length)
                continue;

            if (mat[i][j] > mat[r][c]) {
                int res = dfs(i, j, mat, dp);

                curPath = Math.max(curPath, res);
                
            }
        }
        dp[r][c] = 1 + curPath;
        return dp[r][c];
    }
}
