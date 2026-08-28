class Solution {
    public int lengthOfLongestSubstring(String s) {
        
     
        int n = s.length();
       

        int[] freq = new int[128];

        int maxilen = 0;
        int i = 0;
        for(int j = 0 ; j< n ; j++){
            char c  = s.charAt(j) ;
            freq[c]++;

            while(freq[c] > 1){
                   char ch  = s.charAt(i) ;
                    freq[ch]--;  
                    i++;
            }

             maxilen = Math.max(maxilen  , j-i+1);
        }

        return  maxilen;
    }
}
