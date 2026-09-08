class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        int[] freqS = new int[130];
        int[] freqT = new int[130];
        int required = 0;
        for (char c : t.toCharArray()) {
            if (freqT[c]++ == 0)
                required++;
        }

        int n = s.length();

        int formed = 0;
        int min = (int) 1e9;
        String sb = "";
        int i = 0;
        int start = 0;
        for (int j = 0; j < n; j++) {
            char cur = s.charAt(j);
            freqS[cur]++;

            if (freqT[cur] > 0 && freqS[cur] == freqT[cur])
                formed++;
            while (formed == required) {
                if (min > j - i + 1) {
                    min = j - i + 1;
                    start = i;
                }
                char ch = s.charAt(i);
                freqS[ch]--;
                i++;
                if (freqT[ch] > 0 && freqS[ch] < freqT[ch])
                    formed--;
            }
        }
        return min == (int) 1e9 ? "" : s.substring(start, start+min);
    }
}
