


class Solution {
    public String foreignDictionary(String[] words) {

        // Adjacency list
        Map<Character, List<Character>> map = new HashMap<>();

        // Dependency array (indegree)
        int[] dependency = new int[26];
        Arrays.fill(dependency, -1);

        // Build graph
        for (int i = 1; i < words.length; i++) {

            String previous = words[i - 1];
            String cur = words[i];

            int len = Math.min(previous.length(), cur.length());

            for (int j = 0; j < len; j++) {

                char u = previous.charAt(j);
                char v = cur.charAt(j);

                // First differing character determines the order
                if (u != v) {

                    map.putIfAbsent(u, new ArrayList<>());
                    map.putIfAbsent(v, new ArrayList<>());

                    // Avoid duplicate edges
                    if (!map.get(u).contains(v)) {
                        map.get(u).add(v);

                        if (dependency[u - 'a'] == -1) {
                            dependency[u - 'a'] = 0;
                        }

                        if (dependency[v - 'a'] == -1) {
                            dependency[v - 'a'] = 0;
                        }

                        dependency[v - 'a']++;
                    }

                    break;
                }
            }

            // Invalid case: "abc" comes before "ab"
            if (previous.length() > cur.length() &&
                previous.startsWith(cur)) {
                return "";
            }
        }

        // Count all unique characters, including isolated ones
        Set<Character> unique = new HashSet<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                unique.add(ch);

                if (dependency[ch - 'a'] == -1) {
                    dependency[ch - 'a'] = 0;
                }
            }
        }

        // Initialize BFS queue
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (dependency[i] == 0) {
                queue.offer((char) (i + 'a'));
            }
        }

        StringBuilder answer = new StringBuilder();
        int processed = 0;

        // Topological sort
        while (!queue.isEmpty()) {

            char u = queue.poll();

            answer.append(u);
            processed++;

            if (map.containsKey(u)) {
                for (char v : map.get(u)) {

                    dependency[v - 'a']--;

                    if (dependency[v - 'a'] == 0) {
                        queue.offer(v);
                    }
                }
            }
        }

        // Cycle detection
        if (processed != unique.size()) {
            return "";
        }

        return answer.toString();
    }
}
