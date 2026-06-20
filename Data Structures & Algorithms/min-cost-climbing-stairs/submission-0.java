class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return findCost(cost);
    }

    int findCost(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            int fst = arr[i - 1] + dp[i - 1];

            int sec = arr[i - 2] + dp[i - 2];

            dp[i] = Math.min(fst, sec);
        }
        return dp[n];
    }
}
