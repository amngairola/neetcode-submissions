class Solution {
    public String gcdOfStrings(String s1, String s2) {
        

        if(!(s1 + s2).equals(s2 + s1)) return "";


     int g = gcd(s1.length(), s2.length());


        return s1.substring(0 , g);
    }

    int gcd(int a , int b){
        return b == 0 ? a   : gcd( b  , a % b);
    }
}