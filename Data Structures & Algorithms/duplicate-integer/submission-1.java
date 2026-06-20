class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer , Integer> mp =  new HashMap<>();
       

        int n = nums.length;
        for(int i =0; i<n ; i++){
            int cur = nums[i];
            mp.put(cur , mp.getOrDefault(cur , 0)+1);
            if(mp.get(cur) > 1) return true;
        }

        return false;
    }
}