class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int s = 0;
        int e = 0;

        for (int i = 0; i < n; i++) {
            e += nums[i];
            s = Math.max(nums[i] , s);
        }
        int ans = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            int parts = devide(nums, mid);

            if (parts <= k) {
               ans = mid;
                e = mid - 1;
            } else if (parts > k) {
                s = mid + 1; 
            } 
        }
        return ans;
    }

    int devide(int[] arr, int k) {
        int sum = arr[0];
        int parts = 1;

        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];

            if (sum > k) {
                sum = arr[i];
                parts++;
            }
        }

        return parts;
    }
}