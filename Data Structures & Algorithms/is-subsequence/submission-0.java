class Solution {
    public boolean isSubsequence(String s, String t) {
      return  subseq(s.length()-1 , t.length()-1 , s , t);
    }

    boolean subseq(int i  , int j , String s, String t){
        if(i<0 ) return true;
        if(j<0) return false;

        if(s.charAt(i) == t.charAt(j)){
           if( subseq(i-1 , j-1 , s , t)) return true;
        }

        
        return subseq(i, j-1 , s , t);
        
    }
}