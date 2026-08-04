class Solution {
    public boolean search(int[] nums, int target) {
      int ans = findMin(nums , target) ;
      return ans != -1 ? true : false;
    }

     public int findMin(int[] nums , int k) {
        int n = nums.length;
        

        int s = 0;
        int e = n-1;
       
        
        while (s <= e) {
            
            int mid = s + (e - s) / 2;

            // if left sorted
            if(nums[mid]==k) return mid;
            if(nums[s] == nums[mid])s++;

            else if (nums[s] < nums[mid]) {
                
                if(k >= nums[s] && k < nums[mid]){
                    e = mid-1;
                }else{
                    s = mid + 1;
                }
               
            }
            // if right sorted
            else {

              if(k > nums[mid] && k <= nums[e]){
                    s = mid + 1;
                }else{
                    e = mid-1;
                }
            }
        }
        return -1;
    }
}