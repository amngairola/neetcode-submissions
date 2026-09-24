class Solution {
    public int singleNumber(int[] nums) {
        
        int or = nums[0];
        for(int i = 1; i<nums.length ; i++){
            or= or ^ nums[i];
        }

        return or;
    }
}
