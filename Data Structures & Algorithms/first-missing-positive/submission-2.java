class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int num = 1;

        for (int x : nums) {
            if (x < num)
                continue;
            if (x == num)
                num++;
            else if (x > num)
                return num;
        }

        return num;
    }
}