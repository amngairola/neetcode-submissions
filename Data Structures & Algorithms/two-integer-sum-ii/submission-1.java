class Solution {
    public int[] twoSum(int[] nums, int k) {
        
        int s = 0;
        int e = nums.length-1;

        while(s<=e){

                if(nums[s]+nums[e] == k)return new int[]{ s+1 , e+1};

                if(nums[s]+nums[e] < k) {
                    s++;
                }else{
                    e--;
                }
        }

        return new int[]{-1 , -1};
    }
}
