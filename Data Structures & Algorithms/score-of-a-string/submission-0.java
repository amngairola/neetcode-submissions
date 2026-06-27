class Solution {
    public int scoreOfString(String s) {
        

        int totel = 0;

        for(int i = 1 ; i<s.length(); i++){
            int cur = (int)s.charAt(i);
            int prev = (int)s.charAt(i-1);
            
            totel += Math.abs(cur - prev);
        }

        return totel;
    }
}