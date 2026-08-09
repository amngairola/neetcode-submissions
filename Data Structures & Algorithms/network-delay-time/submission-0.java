class Solution {
    class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] nodes : times) {
            int a = nodes[0];
            int b = nodes[1];
            int time = nodes[2];

            Pair p = new Pair(b, time);
            adj.get(a).add(p);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        pq.offer(new Pair(k, 0));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            ArrayList<Pair> nbr = adj.get(cur.node);

            for (Pair p : nbr) {
                int newDist = cur.time + p.time;

                if (dist[p.node] > newDist) {
                    dist[p.node] = newDist;
                    pq.offer(new Pair(p.node, newDist));
                }
            }
        }
        int mini = 0;
        for (int i = 1; i <= n; i++) {
            mini = Math.max(mini, dist[i]);
            if(i>=1 && dist[i] == (int)1e9)return -1;
        }

        return mini;
    }
}
