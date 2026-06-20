class Solution {
   
    public int integerBreak(int n) {
      if (n == 2)
            return 1;
        int i = (int) (n / 2) + 1;

        return findSum(i, n, new ArrayList<>());

        
    }

    int findSum(int n, int m, ArrayList<Integer> ls) {
        int[][] dp = new int[n + 1][m + 1];

        

        for (int i = 0; i <= n; i++) {
                    dp[i][0] = 1;
          }
        

        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= m; sum++) {
                int take = 0;
                if (i <= sum) {
                    take = i * dp[i][sum - i];
                }
                dp[i][sum] = Math.max(dp[i - 1][sum], take);
            }
        }

        return dp[n][m];
    }

    
}