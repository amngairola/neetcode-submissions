class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> mp = new ArrayList<>();

        int i = 1;
        while (true) {
            int cur = i * i;

            if (cur > n)
                break;

            mp.add(cur);
            i++;
        }

        return subSet(mp, n);
    }

    int subSet(ArrayList<Integer> mp, int k) {
        int[] dp = new int[k+1];
        dp[0] = 0;

        for (int i = 1; i <= k; i++) {
            int minCnt = (int) 1e9;

            for (int num : mp) {
                
                if (i - num >= 0)
                 minCnt = Math.min(minCnt, 1+dp[i - num]);
            }
            dp[i] = minCnt;
        }

        return dp[k];
    }
}