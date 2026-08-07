class Solution {
    public int ladderLength(String beginW, String endW, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        set.addAll(wordList);
        if (!set.contains(endW))
            return 0;
        Queue<String> q = new LinkedList<>();
        int steps = 1;

        q.offer(beginW);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String st = q.poll();

                if (st.equals(endW))
                    return steps;

                char[] ch = st.toCharArray();

                for (int j = 0; j < ch.length; j++) {
                    char c = 'a';
                    char orig = ch[j];

                    while (c <= 'z') {
                        if (c == orig) {
                            c++;
                            continue;
                        }
                        ch[j] = c;
                        String cur = new String(ch);
                        if (set.contains(cur)) {
                            q.offer(cur);
                            set.remove(cur);
                        }
                        c++;
                    }

                    ch[j] = orig;
                }
            }
            steps++;
        }
        return 0;
    }
}
