class Solution {
    public boolean validPalindrome(String s) {
        

        int i = 0;
        int j = s.length() - 1;

      

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                // skip left

                if (isPallindrome(s, i + 1, j))
                    return true;

                // skip right
                if (isPallindrome(s, i, j - 1))
                    return true;

                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    boolean isPallindrome(String s, int i, int j) {
        int n = s.length();

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }

        return true;
    }
}