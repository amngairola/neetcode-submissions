class Solution {
    public boolean validPalindrome(String s) {
        

        int n = s.length();

      

        if(isPallindrom(s)) return true;

        for(int i = 0; i<n ; i++){

            String left ="";
             if(i > 0) left   = s.substring(0 , i);
            String right = "";
             if(i < n-1) right = s.substring(i+1 , n);

            String sub = left + right;
            if(isPallindrom(sub)) return true;

        }

        return false;
    }


    boolean isPallindrom(String s){
        int n = s.length();

        int i = 0;
        int j = n-1;


        while(i<j){
            if( s.charAt(i++) != s.charAt(j--) ) return false;
        }

        return true;
    }
}