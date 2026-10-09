class Solution {
    int totleSum;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        totleSum = 0;

        for (int i = 0; i < n; i++) totleSum += nums[i];

        int[][] dp = new int[n][2 * totleSum + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return tSum(0, 0, nums, target, dp);
    }

    int tSum(int i, int sum, int[] arr, int t, int[][] dp) {
        if (i >= arr.length) {
            if (sum == t)
                return 1;

            return 0;
        }

        if (dp[i][sum + totleSum] != Integer.MIN_VALUE)
            return dp[i][sum + totleSum];

        int l = tSum(i + 1, sum + arr[i], arr, t, dp);

        int r = tSum(i + 1, sum - arr[i], arr, t, dp);

        return dp[i][sum + totleSum] = l + r;
    }
}
