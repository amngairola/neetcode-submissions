class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if( n > m) return false;

        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for(char c : s1.toCharArray()){
            c1[c-'a']++;
        }


        int l = 0 ;
        int r = 0 ;
        while(r < m){
            
            
            if(r-l+1 > n){
                char c  = s2.charAt(l) ;
                c2[c-'a']--;
                l++;
            }

            char c  = s2.charAt(r) ;
            c2[c-'a']++;
            r++;
            if(Arrays.equals(c1 , c2)) return true;
        }
       

        // for(int i = 0 ; i< n ; i++){
        //     char c  = s2.charAt(i) ;
        //     c2[c-'a']++;
        // }

        // if(Arrays.equals(c1 , c2)) return true;
        
        // for(int i = n ; i< m ; i++){
        //     char c  = s2.charAt(i) ;
        //     c2[c-'a']++;
        //     c2[s2.charAt(i - n)-'a']--;
        //     if(Arrays.equals(c1 , c2)) return true;
        // }
        return false;
    }
}
