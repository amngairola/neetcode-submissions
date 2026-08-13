class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return threeSum(nums, target);
    }

    List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // if(target<0) return ans;
        int n = nums.length;
        HashSet<List<Integer>> hs = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            for (int x = i + 1; x < n - 2; x++) {
                int j = x + 1;
                int k = n - 1;

                while (j < k) {
                  long sum =  (long)  nums[i] + nums[j] + nums[k] + nums[x];

                    if (sum == target) {
                        ArrayList<Integer> cur =
                            new ArrayList(Arrays.asList(nums[i], nums[j], nums[k], nums[x]));

                        if (!hs.contains(cur)) {
                            ans.add(cur);
                            hs.add(cur);
                        }

                        j++;
                        k--;
                    } else if (sum < target)
                        j++;

                    else
                        k--;
                }
            }
        }

        return ans;
    }
}