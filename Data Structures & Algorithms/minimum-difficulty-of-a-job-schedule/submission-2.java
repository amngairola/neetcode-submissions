class Solution {
    public int minDifficulty(int[] jd, int d) {
        if (jd.length < d)
            return -1;

        int[][] dp = new int[jd.length + 1][d + 1];

        for (int i = 0; i < jd.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return shedule(0, jd, d, dp);
    }

    int shedule(int i, int[] jobs, int d, int[][] dp) {
        if (i >= jobs.length) {
            if (d == 0)
                return 0;

            return Integer.MAX_VALUE;
        }
        if (d == 0)
            return Integer.MAX_VALUE;

        if (dp[i][d] != -1)
            return dp[i][d];

        int curMax = Integer.MIN_VALUE;
        int maxi = Integer.MAX_VALUE;

        for (int j = i; j <= jobs.length - d; j++) {
            curMax = Math.max(curMax, jobs[j]);

            int res = shedule(j + 1, jobs, d - 1, dp);
            if (res != Integer.MAX_VALUE)
                maxi = Math.min(maxi, curMax + res);
        }

        return dp[i][d] = maxi;
    }
}
