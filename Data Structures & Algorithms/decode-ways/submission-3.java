class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.trim().isEmpty())
            return 0;

        if (s.charAt(0) == '0')
           return 0;
        ;
        return ways(s);
    }

    int ways(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
       

        for (int i = s.length() - 1; i >= 0; i--) {

        if (s.charAt(i) == '0'){
           dp[i] = 0;
           continue;
        }
            int ans = 0;
            // single
            ans += dp[i + 1];
            // double dig
            if (i + 1 < s.length()) {
                int curNumber = Integer.parseInt(s.substring(i, i + 2));

                if (curNumber <= 26)
                    ans += dp[i + 2];
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}
