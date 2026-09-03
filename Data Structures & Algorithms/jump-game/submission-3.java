class Solution {
    public boolean canJump(int[] nums) {
         if (nums.length == 1)
            return true;
        if (nums[0] == 0)
            return false;

        return jumps(nums);
    }

    boolean jumps(int[] arr) {
        int n = arr.length ;
        boolean[] dp = new boolean[n + 1];

        dp[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            int farthest = arr[i] + i;
            boolean res = false;
            for (int j = i + 1; j <= farthest; j++) {
                res = dp[j];
                if (res)
                    break;
            }
            dp[i] = res;
        }
        return dp[0];
    }
}
