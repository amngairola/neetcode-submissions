class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    int rob(int[] arr, int i, int m) {
        int prev = 0;
        int prev2 = 0;

        for (int j = i+1; j <= m; j++) {
            int nr = prev;

            int rb = arr[j - 1];

            if (j - 2 >= i)
                rb += prev2;

            int cur = Math.max(nr, rb);

            prev2 = prev;
            prev = cur;
        }

        return prev;
    }
}
