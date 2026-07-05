class Solution {
    public int majorityElement(int[] nums) {
        
        int ans = nums[0];
        int freq = 1;

        for(int n : nums){
            if(ans == n){
                freq++;
            }else{
                freq--;
            }

            if(freq == 0){
                ans = n;
                freq=1;
            }
        }

return ans;
    }
}