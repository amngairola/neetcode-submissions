class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0)
            return false;

        return subsum(nums, n, sum / 2);
    }

    boolean subsum(int[] arr, int n, int k) {
        boolean[][] dp = new boolean[n + 1][k+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= k; sum++) {
                boolean np = dp[i - 1][sum];

                boolean p = false;

                if (arr[i-1] <= sum) {
                    p = dp[i - 1] [sum - arr[i-1]];
                }

                dp[i][sum] = p || np;
            }
        }
        return dp[n][k];
    }
}
