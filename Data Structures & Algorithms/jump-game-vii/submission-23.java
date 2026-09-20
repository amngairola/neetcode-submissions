class Solution {
    public boolean canReach(String s, int min, int max) {

        int n = s.length();

        boolean[]dp = new boolean[n];
        dp[0] = true;


        int cnt = 0;

        for(int i = min ; i<n ; i++){

            int r = i-min;
            int l = i-max-1;

            
            if(dp[r]){
                cnt++;
            }
            if(l >= 0 && dp[l]){
                cnt--;
            }


            if(s.charAt(i) == '0' && cnt>0){
                dp[i] = true;
            }
        }

     return dp[n-1];
    }
}