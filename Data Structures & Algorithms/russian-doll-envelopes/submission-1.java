class Solution {
    public int maxEnvelopes(int[][] mat) {
        Arrays.sort(mat, (a, b) -> Integer.compare(a[0], b[0]));
        return maxAnvlp(mat.length, mat);
    }

    int maxAnvlp(int n, int[][] arr) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int notTake = dp[i + 1][prev + 1];

                int take = 0;

                if (prev == -1 || (arr[i][0] > arr[prev][0] && arr[i][1] > arr[prev][1])) {
                    take = 1 + dp[i + 1][i + 1];
                }

                dp[i][prev + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
}