class Solution {
  public int maxSubArray(int[] nums) {
         int maxi = -(int)1e9;
         int curSum = 0;
         for(int i = 0; i<nums.length ; i++){
                curSum += nums[i];
                maxi = Math.max(curSum , maxi);
                if(curSum < 0) curSum = 0;
         }

        return maxi;
    }
}
