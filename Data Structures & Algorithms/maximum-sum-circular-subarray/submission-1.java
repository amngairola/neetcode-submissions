class Solution {
      // Circular maximum = total - minimum
    public int maxSubarraySumCircular(int[] nums) {
        int maxi = -(int) 1e9;
        int curMax = 0;

        int mini = (int) 1e9;
        int curMin = 0;

        int totel = 0;
        
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            maxi = Math.max(curMax, maxi);

            curMin = Math.min(curMin + nums[i], nums[i]);
            mini = Math.min(curMin, mini);

            totel += nums[i];
        }
        if (maxi < 0)
            return maxi;

        return Math.max(maxi, totel - mini);
    }

  
}