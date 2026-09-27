class Solution {
    public int mostBooked(int n, int[][] met) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] m : met) {
            pq.offer(m);
        }
        boolean[] isUsed = new boolean[n];
        int[] endTime = new int[n];
        int[] maxi = new int[n];

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            int i = -1;
            int min = (int) 1e9;

            for (int j = 0; j < n; j++) {
                if (endTime[j] <= cur[0]) {
                    isUsed[j] = false;
                }
                if (isUsed[j]) {
                    if (min > endTime[j]) {
                        min = endTime[j];
                        i = j;
                    }
                } else {
                    i = j;
                    break;
                }
            }

            int duration = cur[1] - cur[0];

            if (endTime[i] <= cur[0]) {
               endTime[i] = cur[1];
            } else {
                endTime[i] += duration;
            }

            maxi[i]++;
            isUsed[i] = true;
        }

        int ans = 0;
        int idx=0;

        for (int j = 0; j < n; j++) {
            if (ans < maxi[j]) {
                ans = maxi[j];
                idx = j;
            }
        }
        return idx;
    }
}