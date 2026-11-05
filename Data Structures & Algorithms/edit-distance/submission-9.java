class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, word1, 0, word2, dp);
    }

    int dfs(int i, String s, int j, String t, int[][] dp) {
        if (j >= t.length()) {
            return s.length() - i;
        }

        if (i >= s.length()) {
            return t.length() - j;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int np = Integer.MAX_VALUE;

        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = dfs(i + 1, s, j + 1, t, dp);
        }
        int insert = 1 + dfs(i, s, j + 1, t, dp);
        int del = 1 + dfs(i + 1, s, j, t, dp);
        int rep = 1 + dfs(i + 1, s, j + 1, t, dp);

        np = Math.min(rep, Math.min(del, insert));

        return dp[i][j] = np;
    }
}
