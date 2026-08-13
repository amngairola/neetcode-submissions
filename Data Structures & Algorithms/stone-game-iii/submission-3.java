class Solution {
    public String stoneGameIII(int[] s) {
        int res = solve(s);

        if (res > 0)
            return "Alice";
        if (res < 0)
            return "Bob";

        return "Tie";
    }

    int solve(int[] arr) {
        int[] dp = new int[arr.length + 1];

        dp[arr.length] = 0;

        for (int i = arr.length - 1; i >= 0; i--) {

            int p1 = arr[i] - dp[i + 1];
            // solve(i + 1, arr);

            int p2 = Integer.MIN_VALUE;
            if (i + 1 < arr.length)
                p2 = arr[i] + arr[i + 1] - dp[i + 2];
            // solve(i + 2, arr);

            int p3 = Integer.MIN_VALUE;
            if (i + 2 < arr.length)
                p3 = arr[i] + arr[i + 2] + arr[i + 1] - dp[i + 3];
            // solve(i + 3, arr);
            dp[i] = Math.max(p1, Math.max(p2, p3));
        }

        return dp[0];
    }
}