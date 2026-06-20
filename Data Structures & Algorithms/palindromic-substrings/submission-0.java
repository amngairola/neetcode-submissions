class Solution {
    public int countSubstrings(String s) {
        
  
       

        return commanSub(s);
    }

   int commanSub(String s) {
     
     int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
