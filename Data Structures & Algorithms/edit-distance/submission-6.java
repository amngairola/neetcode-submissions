class Solution {
    public int minDistance(String w1, String w2) {

        if(w1.length() == 0){
            return w2.length();
        }
        if(w2.length() == 0){
           return  w1.length();
        }

        int[][] dp = new int[w1.length()+1] [w2.length()+1];

        for(int i = 0;i<=w1.length() ; i++){
            Arrays.fill(dp[i] ,(int) 1e9 );
        }


        return findMin(0, w1, 0, w2 , dp);
    }

    int findMin(int i, String s, int j, String t , int[][] dp) {
    
        if (i >= s.length() && j >= t.length()) {
            // if(s.charAt(i) != t.charAt(j)) return
            return 0;
        } else if (i < s.length() && j >= t.length()) {
            return s.length() - i;
        } else if (i >= s.length() && j < t.length()) {
            return t.length() - j;
        }
        if(dp[i][j] != (int) 1e9 )return dp[i][j];

        int np = (int) 1e9;
        int p = (int) 1e9;
        
        if (s.charAt(i) == t.charAt(j)) {
            np = findMin(i + 1, s, j + 1, t , dp);
        } else {
            // instrt
            int insrt = findMin(i, s, j + 1, t , dp);
            // del
            int del = findMin(i + 1, s, j, t , dp);
            // replace
            int replace = findMin(i + 1, s, j + 1, t,  dp);

            p = 1 + Math.min(insrt, Math.min(del, replace));
        }
        // return min

        return   dp[i][j] = Math.min(np, p);
    }
}
