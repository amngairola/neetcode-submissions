class Solution {
    int totel ;
    public int findTargetSumWays(int[] nums, int target) {

         totel = 0;
        for(int i = 0 ;i<nums.length ; i++)totel+=nums[i];

        
        int[][] dp = new int[nums.length][ 2 * totel  + 1];

        for(int i = 0 ;i<nums.length ; i++) Arrays.fill(dp[i] , Integer.MIN_VALUE);

       return solve(0 , nums , 0 , target , dp);
    }

   int solve(int i , int[] arr , int sum , int target ,int[][] dp){

        if(i >= arr.length){
            if(sum == target ){
                return 1;
            }
            return 0;
        }

        if(dp[i][ sum + totel] != Integer.MIN_VALUE){
            return dp[i][sum + totel];
        }


        // add
        int add = solve(i+1 , arr , sum+arr[i], target , dp);

        // remove
        int remove =  solve(i+1 , arr , sum-arr[i], target , dp);
    

        return dp[i][sum + totel]  = add + remove;
    }
}
