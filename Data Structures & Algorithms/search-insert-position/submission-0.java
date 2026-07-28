class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int s = 0;
        int e = nums.length;

        while(s<e){
            int mid = s+(e-s)/2;

          if(nums[mid] == target) return mid;
         
           else if(nums[mid] > target){
                e = mid;
            }else {
                s = mid+1;
            }
        }

        return s;
    }
}