class Solution {
    public int lengthOfLIS(int[] nums) {
        return lis(nums);
    }

    int lis(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

       
        for (int i = 1; i <= n; i++) {
            for (int prev = 0; prev <= n; prev++) {
                int np = dp[i - 1][prev];

                int p = 0;

                if (prev == 0 || nums[i-1] < nums[prev-1]) {
                    p = 1 + dp[i - 1][i];
                }
                 dp[i][prev] = Math.max(np, p);
            }

           
        }

        return dp[n][0];
    }
}
