class Solution {
    public String longestPalindrome(String s) {
       

        return commanSub(s);
    }

    String commanSub(String s) {
        String ans = "";
      int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > maxi) {
                        maxi = j - i + 1;
                        ans = s.substring(i, j+1);
                    };
                }
            }
        }

        return ans;
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
