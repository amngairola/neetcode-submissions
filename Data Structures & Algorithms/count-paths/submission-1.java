class Solution {
    public int uniquePaths(int m, int n) {
        return findPaths(m, n);
    }

    int findPaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(i==0 && j == 0)continue;
                // top
                int top = 0;
                if( i > 0) top = dp[i-1][j];
                // (i - 1, j, m, n);

                // left

                int left = 0;
                if(j > 0) left = dp[i][j-1];
                
                // findPaths(i, j - 1, m, n);

                dp[i][j] =  top + left;
            }
        }

        return dp[m-1][n-1];
    }
}
