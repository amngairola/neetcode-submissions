class Solution {
    List<List<Integer>> ans;
   

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        ans = new ArrayList<>();
    

        Arrays.sort(nums);

        sub(0, nums,target, new ArrayList<>());

        return ans;
    }

    void sub(int i, int[] nums, int x, ArrayList<Integer> temp) {
      
        if (x == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }

            if (nums[j] > x) {
                break;
            }

            temp.add(nums[j]);
            sub(j + 1, nums, x - nums[j], temp);
            temp.remove(temp.size() - 1);
        }
        
    }
}
