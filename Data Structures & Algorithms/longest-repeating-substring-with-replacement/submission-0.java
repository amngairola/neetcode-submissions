class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int[] freq = new int[27];

        int maxi = 0;

        int i = 0;

        int maxFreq = 0;
        for (int j = 0; j < n; j++) {
            char cur = s.charAt(j);
            freq[cur - 'A']++;

            maxFreq = Math.max(maxFreq, freq[cur - 'A']);

            while((j - i + 1) - maxFreq > k)
            {
                 freq[s.charAt(i) - 'A']--;
                 i++;
            } 
            
            
            maxi = Math.max(maxi, j - i + 1);
            
        }

        return maxi;
    }

    // s - string char  A-z;

    // k = replace k with any char from A-Z
    // find longest subString which contain only 1  dist char
    //

    // string can contain any char
    // fre[each char] > 1;
    // if( k - freq[ch] +1 > 0 ) dist char
    //
}
