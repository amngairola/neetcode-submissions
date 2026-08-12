class Solution {
    public int change(int amount, int[] coins) {
        return targetSum(amount, coins);
    }

    int targetSum(int x, int[] arr) {
        int[] dp = new int[x+1];
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            // int[] cur = new int[x+1];
            // cur[0] = dp[0];

            for (int k = 0; k <= x; k++) {
                int np = dp[k];
                // targetSum(i - 1, k, arr);

                int p = 0;

                if (k >= arr[i])
                    p = dp[k - arr[i]];
                // targetSum(i, k - arr[i], arr);

                dp[k] = p + np;
            }

            // dp = cur;
        }
        return dp[x];
    }
}
