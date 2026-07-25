class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int x = nums.length;

        HashMap<Integer , Integer> mp= new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();

         for(int n : nums){

            mp.put(n  , mp.getOrDefault(n, 0) +1);
            if(mp.get(n) > x/3 && !hs.contains(n) ){
                ans.add(n);
                hs.add(n);
               
            }
         }
        return ans;
    }
}