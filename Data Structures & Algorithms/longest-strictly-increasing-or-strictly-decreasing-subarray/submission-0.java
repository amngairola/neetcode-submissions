class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        return Math.max(lis(nums), lds(nums));
    }

    int lis(int[] arr) {
        int n = arr.length;

        int maxi = 1;

        int len = 1;
        for (int i = 1; i < n; i++) {
            int prev = arr[i - 1];
            int cur = arr[i];

            if (prev < cur) {
                len++;
                maxi = Math.max(len, maxi);
            } else {
                len = 1;
            }

            
        }

        return maxi;
    }

    int lds(int[] arr) {
        int n = arr.length;

        int maxi = 1;

        int len = 1;
        for (int i = 1; i < n; i++) {
            int prev = arr[i - 1];
            int cur = arr[i];

            if (prev > cur) {
                len++;
                maxi = Math.max(len, maxi);
            } else {
                len = 1;
            }

            
        }

        return maxi;
    }
}