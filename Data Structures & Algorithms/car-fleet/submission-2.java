class Solution {
    class Pair {
        int pos;
        int sp;
        double at;

        Pair(int pos, int sp, double at) {
            this.pos = pos;
            this.sp = sp;
            this.at = at;
        }
    }
    public int carFleet(int target, int[] pos, int[] sp) {
        int n = pos.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.pos - a.pos);
        for (int i = 0; i < n; i++) {
            double time = (double) (target - pos[i]) / sp[i];
            Pair p = new Pair(pos[i], sp[i], time);
            pq.offer(p);
        }

        int fleet = 0;
        double prevTime = -1;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.at > prevTime) {
                prevTime = p.at;
                fleet++;
            }
        }

        return fleet;
    }
}
