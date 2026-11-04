class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        // Create two arrays: left and right
        int[] l = new int[n];
        int[] r = new int[n];

        int ans = 0;

        // 1. Traverse from left to right
        l[0] = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                l[i] = 1 + l[i - 1];
            } else {
                l[i] = 1;
            }
        }

        // 2. Traverse from right to left
        r[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                r[i] = 1 + r[i + 1];
            } else {
                r[i] = 1;
            }
        }

        // 3. Calculate minimum candies required
        for (int i = 0; i < n; i++) {
            int curCandie = Math.max(l[i], r[i]);
            ans += curCandie;
        }

        return ans;
    }
}