class Solution {
     int totelSum;
     int t ;
    public int findTargetSumWays(int[] arr, int target) {
      totelSum  = 0;
        t  = target;
        for (int i = 0; i < arr.length; i++) {
            totelSum += arr[i];
        }

        int[][] dp = new int[arr.length][2 * totelSum + 1];

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
       return sum(0, arr, 0, dp);
        
    }

    int sum(int i, int[] arr, int sum, int[][] dp) {
        if (i >= arr.length) {
            if (sum == t)
                return 1;

            return 0;
        }

        if (dp[i][sum + totelSum] != Integer.MIN_VALUE)
            return dp[i][sum + totelSum];

        // add

        int l = sum(i + 1, arr, sum + arr[i], dp);

        // sub

        int r = sum(i + 1, arr, sum - arr[i], dp);

        return dp[i][sum + totelSum] = l + r;
    }
}
