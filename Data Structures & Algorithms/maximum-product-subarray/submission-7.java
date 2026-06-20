class Solution {
    static int maxi = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        maxi = Integer.MIN_VALUE;
        return  prod(nums);
      
    }

    int prod(int[] arr) {
        int n = arr.length;
        int[]dp = new int[n ];

        for (int i = 0; i < n; i++) {
            int prod = 1;

            for (int j = i; j < arr.length; j++) {
                prod *= arr[j];
                maxi = Math.max(maxi, prod);
                dp[j] = maxi;
            }

           
        }
        return dp[n-1];
    }
}
