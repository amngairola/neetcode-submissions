class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        

        int i = 0;

        int mini = (int) 1e9;
        
        int sum = 0;
        for(int j = 0; j<nums.length ; j++){


            sum = sum + nums[j];

            while(sum >= target){
                mini = Math.min(mini , j-i+1);
                sum-=nums[i];
                i++;
                
            }

        }

        if(mini == (int) 1e9) return 0;

        return mini;
    }
}