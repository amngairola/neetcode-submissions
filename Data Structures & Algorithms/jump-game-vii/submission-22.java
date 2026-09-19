class Solution {
    public boolean canReach(String s, int min, int max) {
           int m = s.length();
     if (s.charAt(0) == '1' || s.charAt(m - 1) == '1') {
            return false;
        }

        return f(s, min, max);
    }

    boolean f(String s, int min, int max) {
        int m = s.length();
        boolean[] dp = new boolean[m];
        dp[0] = true;

       
        int cnt = 0;
        for (int i = min; i < m; i++) {
            int l = i - max - 1;
            int r = i - min;

            if (dp[r])
                cnt++;

            if (l >= 0 && dp[l])
                cnt--;

            if (s.charAt(i) == '0' && cnt > 0) {
                dp[i] = true;
            }
        }

        return dp[m - 1] ;
    }
}
