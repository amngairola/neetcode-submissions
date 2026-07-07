class Solution {
    public int pivotIndex(int[] nums) {
        int[] rs = rightSum(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
               sum += nums[i - 1];
            }

           
            if (sum == rs[i]) {
                return i;
            }
        }

        return -1;
    }

    int[] rightSum(int[] arr) {
        int[] rs = new int[arr.length];

        int sum = 0;
        rs[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            sum += arr[i + 1];
            rs[i] = sum;
        }

        return rs;
    }
}