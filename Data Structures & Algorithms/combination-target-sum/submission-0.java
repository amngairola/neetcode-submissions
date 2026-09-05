class Solution {
    List<List<Integer>> ans;
    HashSet<List<Integer>> set;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        sub(0, nums, 0, target, new ArrayList<>());

        return ans;
    }

    void sub(int i, int[] nums, int sum, int x, ArrayList<Integer> temp) {
        if (sum == x) {
            if (!set.contains(temp)) {
                ans.add(new ArrayList<>(temp));
                set.add(temp);
            }

            return;
        }

        if (sum > x || i >= nums.length)
            return;

        temp.add(nums[i]);
        sub(i, nums, sum + nums[i], x, temp);

        temp.remove(temp.size() - 1);
        sub(i + 1, nums, sum, x, temp);
    }
}
