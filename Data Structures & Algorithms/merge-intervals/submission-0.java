class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int[] interval : intervals) {
            pq.offer(interval);
        }

        ArrayList<int[]> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (!ans.isEmpty() && ans.get(ans.size() - 1)[1] >= cur[0]) {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], cur[1]);
            } else {
                ans.add(cur);
            }
        }

        int[][] res = new int[ans.size()][2];

        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}