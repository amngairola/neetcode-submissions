class Solution {
    public int appendCharacters(String s, String t) {
        

     return  subseq(0, 0 , s , t);
    
    }
    int subseq(int i  , int j , String s, String t){
        
        while(i < s.length() && s.charAt(i) != t.charAt(j)){
            i++;
        }
        
        if(i == s.length()) return t.length();

        while( i<s.length() &&  j< t.length()){
            if(s.charAt(i) == t.charAt(j)){
            i++;
            j++;
            }else{
                i++;
            }
           
        }

    
        return t.length()-j;
        
    }
}