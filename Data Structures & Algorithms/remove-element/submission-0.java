class Solution {
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);

        int cnt = 0;
        int j = -1;
        int k = -1;

         for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                cnt++;
              }
         }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                j = i;

                while( i < nums.length && nums[i] == nums[j])i++;

                while(i<nums.length){
                    nums[j] = nums[i];
                    i++;
                    j++;
                }
                break;
            }
        }

        return cnt;
    }

     //[0, 0, 1, 2, 2, 2, 2, 3, 4]
}