class Solution {
    public int lengthOfLIS(int[] nums) {
        return lis(nums);
    }

    int lis(int[] nums) {
        int n = nums.length;

        int[]dp = new int[n + 1];
        Arrays.fill(dp , 1);

       
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev <i; prev++) {
               

                if ( nums[i] > nums[prev]) {
                 dp[i] = Math.max(1 +dp[prev],  dp[i]);
                }
                 
            }

           
        }
        int ans = 0;
  for (int i = 0; i < n; i++) ans = Math.max(ans , dp[i]);


        return ans;
    }
}
