class Solution {
    public int characterReplacement(String s, int k) {
        

        int n = s.length();

        int maxilen = 0;
        int maxiF = 0;

        int[] frq = new int[26];
        int i = 0;

        for(int j = 0 ;j<n ; j++){

            char c = s.charAt(j);
            frq[c - 'A']++;

            maxiF = Math.max(maxiF ,  frq[c - 'A']);

            while((j-i+1) - maxiF > k){
                char ch = s.charAt(i);
                frq[ch - 'A']--;
                i++;
            }
                
            maxilen = Math.max(maxilen  , j-i+1);
        }

        return maxilen;
    }
}
