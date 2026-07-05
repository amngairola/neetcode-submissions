class Solution {
    public int maxDifference(String s) {
        
        HashMap<Character , Integer> mp = new HashMap<>();

        for(char c : s.toCharArray()){
            mp.put(c , mp.getOrDefault(c, 0)+1);
        }

        int odd = -(int)1e9;
        int even = (int)1e9;

       for (int v : mp.values()) { 

                if(v % 2 == 0){
                    even  = Math.min(even , v);
                }else{
                    odd = Math.max(odd , v);
                }
        };

        return odd - even;
    }
}