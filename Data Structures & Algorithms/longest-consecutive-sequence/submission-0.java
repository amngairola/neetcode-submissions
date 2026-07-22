class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hs.add(nums[i]);
        }

        int ans = 0;

        for (int cur : hs) {
            int cnt = 1;
            if (!hs.contains(cur - 1)) {
                while (hs.contains(cur + 1)) {
                    cnt++;
                    cur++;
                }
            }
            ans = Math.max(cnt, ans);
        }

        return ans;
    }
}
