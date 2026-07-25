class Solution {
    public int maxProfit(int[] prices) {
        return byAsell( prices);
    }

    int byAsell( int[] arr) {
        int[][] dp = new int[arr.length][2];
        dp[arr.length - 1][0] = 0;
        dp[arr.length - 1][1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            int a = dp[i + 1][0];
            int b = -arr[i] + dp[i + 1][1];

            dp[i][0] = Math.max(a, b);

            int x = dp[i + 1][1];

            int y = arr[i] + dp[i + 1][0];
            dp[i][1] = Math.max(x, y);
        }
        return dp[0][0];
    }
}