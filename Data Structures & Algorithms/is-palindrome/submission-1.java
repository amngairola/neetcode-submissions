class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            char a = s.charAt(i);
            char b = s.charAt(j);
            if (Character.isDigit(a) & Character.isDigit(b)) {
                if (a != b)
                    return false;
            }
            if (Character.toLowerCase(a) != Character.toLowerCase(b))
                return false;

            i++;
            j--;
        }

        return true;
    }
}
