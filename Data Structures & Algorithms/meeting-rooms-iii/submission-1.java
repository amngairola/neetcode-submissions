class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] m : meetings) {
            pq.offer(m);
        }

        boolean[] isUsed = new boolean[n];
        int[] endTime = new int[n];

        int[] maxUsed = new int[n];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int freeRoomIndx = -1;
            int minEndTime = (int) 1e9;

            for (int i = 0; i < n; i++) {
                if (endTime[i] <= cur[0])
                    isUsed[i] = false;

                if (isUsed[i]) {
                    if (minEndTime > endTime[i]) {
                        minEndTime = endTime[i];
                        freeRoomIndx = i;
                    }
                } else {
                    //  minTime = endTime[i];
                    freeRoomIndx = i;
                    break;
                }
            }

            // ASSIGN NEW MEET

            int duration = cur[1] - cur[0];

            if (endTime[freeRoomIndx] <= cur[0]) {
                endTime[freeRoomIndx] = cur[1];
            } else {
                endTime[freeRoomIndx] += duration;
            }

            maxUsed[freeRoomIndx]++;
            isUsed[freeRoomIndx] = true;
        }

        int ans = 0;
        int indx = -1;
        for (int i = 0; i < n; i++) {
            int x = maxUsed[i];

            if (ans < maxUsed[i]) {
                ans = maxUsed[i];
                indx = i;
            }
        }

        return indx;
    }
}
