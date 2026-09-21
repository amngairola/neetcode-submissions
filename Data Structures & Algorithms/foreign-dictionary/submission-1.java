class Solution {
    public String foreignDictionary(String[] w) {
        int n = w.length;

        HashMap<Character, ArrayList<Character> > adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : w) {
                    for (char c : word.toCharArray()) {
                        inDegree.putIfAbsent(c, 0);
                    }
                }
        for (int i = 0; i < n - 1; i++) {
            String s = w[i];
            String t = w[i + 1];

            if (s.length() > t.length() && s.startsWith(t)) {
                return ""; // Invalid order
            }

            for (int k = 0; k < Math.min(s.length(), t.length()); k++) {
                char u = s.charAt(k);
                char v = t.charAt(k);
                if (u != v) {
                    adj.putIfAbsent(u, new ArrayList<>());
                    adj.get(u).add(v);

                    
                    inDegree.put(v, inDegree.get(v) + 1);
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);

            if (adj.containsKey(cur)) {
                for (char nbr : adj.get(cur)) {
                    inDegree.put(nbr, inDegree.get(nbr) - 1);

                    if (inDegree.get(nbr) == 0) {
                        q.offer(nbr);
                    }
                }
            }
        }

        if (sb.length() != inDegree.size())
            return "";
        return sb.toString();
    }
}
