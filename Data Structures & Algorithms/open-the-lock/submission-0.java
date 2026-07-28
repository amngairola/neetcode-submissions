class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        String s = "0000";

        if (dead.contains(s))
            return -1;

        Queue<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        q.offer(s);

        int cnt = 0;
        vis.add(s);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target))
                    return cnt;

                for (int j = 0; j < 4; j++) {
                    char[] arr = cur.toCharArray();

                    arr[j] = (arr[j] == '9') ? '0' : (char) (arr[j] + 1);
                    String forward = new String(arr);

                    if (!dead.contains(forward) && !vis.contains(forward)) {
                        q.offer(forward);
                        vis.add(forward);
                    }

                    // Restore original character
                    arr = cur.toCharArray();

                    // Move wheel backward
                    arr[j] = (arr[j] == '0') ? '9' : (char) (arr[j] - 1);
                    String backward = new String(arr);

                    if (!dead.contains(backward) && !vis.contains(backward)) {
                        q.offer(backward);
                        vis.add(backward);
                    }
                }
            }
            cnt++;
        }

        
            return -1;
    }
}