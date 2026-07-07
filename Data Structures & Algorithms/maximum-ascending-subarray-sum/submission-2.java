class Solution {
    public int maxAscendingSum(int[] nums) {
        return lis(nums);
    }

    int lis(int[] arr) {
        int n = arr.length;

        int maxiSum = -1;
       

        
        int sum = arr[0];
        
        for (int i = 1; i < n; i++) {
            int prev = arr[i - 1];
            int cur = arr[i];

            if (prev < cur) {
                sum+=cur;
                maxiSum = Math.max(maxiSum , sum);
            } else {
                maxiSum = Math.max(maxiSum , sum);
                sum = cur;
            }

            
        }

        return maxiSum;
    }
}