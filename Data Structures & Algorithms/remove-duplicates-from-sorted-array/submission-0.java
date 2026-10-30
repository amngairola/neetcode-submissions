class Solution {
    public int removeDuplicates(int[] nums) {
        
        int n = nums.length;
        int i  = 0;
        for(int j = 1; j<n  ; j++){

            while(j<n && nums[i] == nums[j])j++;
            if(j >= n)break;

            nums[i+1] = nums[j];
            i++;

        }

        return i+1;
    }
}