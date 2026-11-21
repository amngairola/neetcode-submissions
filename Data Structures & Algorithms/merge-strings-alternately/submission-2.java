class Solution {
    public String mergeAlternately(String s, String t) {
        
        int i = 0 , j = 0;
        StringBuilder sb = new StringBuilder();
        while( i<s.length() && j < t.length()){

            char a = s.charAt(i);
            char b = t.charAt(j);

            sb.append(a).append(b);
            i++;
            j++;

        }

        if(i<s.length()){
                sb.append(s.substring(i , s.length()));
            }

        if( j<t.length()){
            sb.append(t.substring(j , t.length()));
         }
        return sb.toString();
    }
}