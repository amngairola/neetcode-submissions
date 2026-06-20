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
        boolean[] dp= new boolean[k+1];

          dp[0] = true;
        

        for (int i = 1; i <= n; i++) {
             boolean[] cur = new boolean[k+1];
            for (int sum = 0; sum <= k; sum++) {
                boolean np = dp[sum];

                boolean p = false;

                if (arr[i-1] <= sum) {
                    p = dp [sum - arr[i-1]];
                }

                cur[sum] = p || np;
            }

            dp = cur;
        }
        return dp[k];
    }
}
