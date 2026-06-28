class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 1) return strs[0];
        int minilen = (int) 1e9;

        for (String s : strs) {
            minilen = Math.min(minilen, s.length());
        }

        int maxi = -1;
        
        for (int i = minilen; i >= 0; i--) {

            for (int j = 1; j < strs.length; j++) {

                String cur = strs[j];
                String prev = strs[j - 1];

                if (!cur.substring(0, i).equals(prev.substring(0, i)) )
                    break;

                if (j == strs.length-1) {
                    maxi = i;
                   return strs[1].substring(0 ,maxi);
                }
            }
        }

        return " ";
    }
}