class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character , Integer> mp = new HashMap<>();

        int i = 0;
        int maxi = 0;
        if(s.length() == 0  ) return 0;
       
        for (int j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);
           

            mp.put(cur , mp.getOrDefault(cur, 0) +1);

            while (mp.get(cur) > 1) {
                // ch[s.charAt(i) - 'a']--;
                  char leftChar = s.charAt(i);
                mp.put( leftChar, mp.get(leftChar) -1);
                i++;
            }
            maxi = Math.max(maxi, j - i + 1);
        }

        return maxi;
    }
}
