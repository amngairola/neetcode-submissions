class Solution {
      static  int maxi = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        maxi = Integer.MIN_VALUE;
        prod(nums, 0);
        return maxi;
    }

   void prod(int[] arr, int i) {
        if (i == arr.length)
            return ;

        int prod = 1;

        
        for (int j = i; j < arr.length; j++) {
             prod *= arr[j];
             maxi = Math.max(maxi, prod);
        }
       
        prod(arr, i + 1);
       
        return;
    }
}
