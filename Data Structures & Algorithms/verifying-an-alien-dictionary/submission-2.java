class Solution {
    public boolean isAlienSorted(String[] word, String order) {
        int n = word.length;

        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            mp.put(c, i);
        }
        boolean samePrefix = true;

        for (int i = 1; i < word.length; i++) {
            // prev
            String a = word[i - 1];

            // cur string
            String b = word[i];

            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                int x = mp.get(a.charAt(j));
                int y = mp.get(b.charAt(j));

                if (x < y) {
                    samePrefix = false;
                    break;
                }

                if (x > y)
                    return false;
            }

            if (samePrefix  && a.length() > b.length()) {
                return false;
            }
        }

        return true;
    }
}