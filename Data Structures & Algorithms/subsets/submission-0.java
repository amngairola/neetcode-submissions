class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        sub(0, nums, new ArrayList<>());

        return ans;
    }

    void sub(int i, int[] nums, ArrayList<Integer> temp) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        sub(i + 1, nums, temp);

        temp.remove(temp.size() - 1);
        sub(i + 1, nums, temp);
    }
}
