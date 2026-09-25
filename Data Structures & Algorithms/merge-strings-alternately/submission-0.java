class Solution {
    public String mergeAlternately(String w1, String w2) {
        int i = 0;
        int j = 0;

        StringBuilder sb = new StringBuilder();
        while (i < w1.length() && j < w2.length()) {
            sb.append(w1.charAt(i));
            sb.append(w2.charAt(j));
            i++;
            j++;
        }

        if (i < w1.length()) {
            sb.append(w1.substring(i, w1.length()));
        }

        if (j < w2.length()) {
            sb.append(w2.substring(j, w2.length()));
        }

        return sb.toString();
    }
}