
//
class Solution {
    static List<String> dist;
    public boolean wordBreak(String s, List<String> wordDict) {
        dist = new ArrayList<>(wordDict);

        return subset(s);
    }

    boolean subset(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                String part = s.substring(j, i);

                if (dp[j] && dist.contains(part)) {
                   dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
