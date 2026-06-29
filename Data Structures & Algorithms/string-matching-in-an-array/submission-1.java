class Solution {
    public List<String> stringMatching(String[] words) {

        
        HashSet<String> hs = new HashSet<>();

        for (String s : words) {
            for (String t : words) {

                if (s.equals(t))
                    continue;

                if (s.contains(t)) {
                    hs.add(t);
                }
            }
        }

        return new ArrayList<>(hs);
    }

    
}