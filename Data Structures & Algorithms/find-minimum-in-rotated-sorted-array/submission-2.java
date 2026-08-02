class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int s = 0;
        int e = n - 1;
        //[1,2,3,4,5,6]
        // r = 1 [6.1.2.3.4.5]
        // r = 2 [5,6,1,2,3,4]
        // r = 3 [4,5,6,1,2,3]
        // r = 4 [3,4,5,6,1,2]
        // r = 5 [2,3,4,5,6,1]
        // r = 6 [1,2,3,4,5,6]

        int mini = (int) 1e9;
        while (s <= e) {
            if (nums[s] <= nums[e]) {
                mini = Math.min(mini, nums[s]);
                break;
            }
            int mid = s + (e - s) / 2;

            // if left sorted

            if (nums[s] <= nums[mid]) {
                mini = Math.min(mini, nums[s]);
                s = mid + 1;
            }
            // if right sorted
            else {
                mini = Math.min(mini, nums[mid]);
                e = mid - 1;
            }
        }
        return mini;
    }
}
