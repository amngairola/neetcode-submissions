class Solution {

     static int cnt ;
    public int subarraySum(int[] nums, int k) {
        cnt = 0;
   

        HashMap<Integer ,Integer> mp = new HashMap<>();
        mp.put(0 , 1);
        int pre = 0;

        for(int i = 0 ; i<nums.length  ; i++){

            pre+= nums[i];

            if(mp.containsKey(pre-k)){
                cnt+=mp.get(pre-k);
            }

            mp.put(pre, mp.getOrDefault(pre, 0) + 1);



        }
        return cnt;
    }
   
}