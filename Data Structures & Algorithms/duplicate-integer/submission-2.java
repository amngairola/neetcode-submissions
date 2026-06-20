class Solution {
    public boolean hasDuplicate(int[] nums) {
        // HashMap<Integer , Integer> mp =  new HashMap<>();
       
        Arrays.sort(nums);

        int n = nums.length;
        for(int i = 1; i<n ; i++){
            // int cur = nums[i];
            // mp.put(cur , mp.getOrDefault(cur , 0)+1);
            // if(mp.get(cur) > 1) return true;

            if(nums[i-1] == nums[i]) return true;
        }

        return false;
    }
}