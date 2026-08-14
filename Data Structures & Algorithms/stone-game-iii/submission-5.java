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
        
        int n = arr.length;

        int[] dp = new int[n+1];
        dp[n] = 0;


        for(int i = n-1 ; i>= 0 ; i--){

            int one = arr[i] - dp[i+1];

            int two = Integer.MIN_VALUE;
            if(i+1 < n)
            two =  arr[i] + arr[i+1] - dp[i+2];

            int three  = Integer.MIN_VALUE;
             if(i+2 < n)
            three =  arr[i] + arr[i+1] +arr[i+2]  - dp[i+3];


            dp[i] = Math.max(one ,Math.max(two , three));


        }

        return dp[0];
    }
}