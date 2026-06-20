class Solution {
    public int combinationSum4(int[] nums, int target) {
       
        return subSum( nums , target);
    }

    int subSum(int[]arr ,int sum){

        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int i =1; i<=sum ; i++){


            for(int num : arr){
                if(i-num>=0) dp[i]+= dp[i - num] ;
            }

         }
        return dp[sum];
    }
}