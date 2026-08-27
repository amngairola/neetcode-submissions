class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m)
            return false;

        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (char c : s1.toCharArray()) {
            c1[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            char cur = s2.charAt(i);
            c2[cur - 'a']++;
        }

        if (Arrays.equals(c1, c2)) {
            return true;
        }

        for (int i = n; i < m; i++) {
            char cur = s2.charAt(i);
            c2[cur - 'a']++;
            c2[s2.charAt(i - n) - 'a']--;

            if (Arrays.equals(c1, c2)) {
                return true;
            }
        }

        return false;
    }
}
