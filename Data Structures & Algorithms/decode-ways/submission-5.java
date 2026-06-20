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

        int prev = 1;
        int prev2 = 0;
        dp[s.length()] = 1;
       

        for (int i = s.length() - 1; i >= 0; i--) {
        int cur = 0;
        if (s.charAt(i) == '0'){
        //    dp[i] = 0;
           prev2 = prev;
            prev = cur;
           continue;
        }
            int ans = 0;
            // single
            ans += prev;
            // double dig
            if (i + 1 < s.length()) {
                int curNumber = Integer.parseInt(s.substring(i, i + 2));

                if (curNumber <= 26)
                    ans += prev2;
            }
            cur = ans;

            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
