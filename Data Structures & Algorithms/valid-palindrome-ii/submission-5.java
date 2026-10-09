class Solution {
    public boolean validPalindrome(String s) {
        
        int i = 0;
        int j = s.length() - 1;

        while(i<=j){
            
            if(s.charAt(i) != s.charAt(j)){

                if(isPallindome(s , i + 1, j)) return true;
                if(isPallindome(s , i, j-1  )) return true;

                 return false;
            }

            i++;
            j--;

        }
        return true;
    }

    boolean isPallindome(String s , int i , int j){

        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}