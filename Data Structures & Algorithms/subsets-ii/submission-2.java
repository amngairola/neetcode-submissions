class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        solve(0, nums, new ArrayList<>());

        return ans;
    }

    void solve(int i, int[] nums, List<Integer> list) {

        if (i >= nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // Include current element
        list.add(nums[i]);
        solve(i + 1, nums, list);

        // Backtrack
        list.remove(list.size() - 1);

        // Skip duplicate elements
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        // Exclude current element
        solve(i + 1, nums, list);
    }
}