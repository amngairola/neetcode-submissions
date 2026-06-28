class Solution {
    public int lengthOfLastWord(String s) {
        
        int n = s.length();

        int i = n-1;

        while(i>=0 && s.charAt(i) == ' '){
            i--;
        }
        int m = i;

        while(i>=0 && s.charAt(i) != ' '){
            i--;
        }

        return m-i;
    }

    
}