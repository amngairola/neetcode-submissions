class Solution {
    public boolean canReach(String s, int min, int max) {
        int n = s.length();
       
        boolean[] dp = new boolean[n];
        dp[0] = true;
         

        int count = 0;

        for (int i = min; i < n; i++) {

            if(dp[i-min])count++;

            if(i-max-1 >= 0 &&  dp[i-max-1])count--;

            if(s.charAt(i) == '0' && count > 0){
                dp[i] = true;
            }
        }

        return dp[n-1];
    }

}