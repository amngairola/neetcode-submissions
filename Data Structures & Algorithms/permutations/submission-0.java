class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
         ans = new ArrayList<>();
         sub (nums, new ArrayList<>() , new boolean[nums.length]);
         return ans;
    }

    void sub(int[] nums,ArrayList<Integer> temp ,boolean[] used) {
         if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
            }
        
       

        for(int j = 0 ; j<nums.length ; j++){

            if(used[j])continue;

                used[j] = true;
                temp.add(nums[j]);
                sub( nums,temp , used);

                temp.remove(temp.size() - 1);
                 used[j] = false;
                
        }
       
    }
}
