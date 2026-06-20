class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1 )return nums[0];
        return Math.max(rob( nums , 0 , nums.length-1) ,rob( nums , 1 , nums.length) );
    }

    int rob(int[] arr , int i , int m) {
        
       

        int[] dp = new int[m + 1];

        for (int j = i+1; j <= m; j++) {

            int nr = dp[j - 1];

           
            int rb = arr[j-1];

           if(j-2>=i) rb+=dp[j-2];

            dp[j] = Math.max(nr, rb);
        }

        return dp[m];
    }
}
