class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return minCost(days.length, days, costs);
    }

    int minCost(int n, int[] days, int[] cost) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = cost[0] + dp[i - 1];

            int j = i-1;

            while (j >= 0 && days[j] >= days[i-1] - 6) {
                j--;
            }

           dp[i] = Math.min( dp[i], cost[1] + dp[j+1]);

 j = i - 1;
            while (j >= 0 && days[j] >= days[i-1] - 29) {
                j--;
            }

           dp[i] = Math.min( dp[i], cost[2] +  dp[j+1]);
        }
        return dp[n];
    }
}