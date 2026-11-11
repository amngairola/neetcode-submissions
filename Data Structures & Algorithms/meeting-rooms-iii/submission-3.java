
class Solution {
    public int mostBooked(int n, int[][] meetings) {

        // Sort meetings by start time, then end time
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        // Available rooms: smallest room ID first
        PriorityQueue<Integer> available = new PriorityQueue<>();

        // Busy rooms: earliest end time, then smallest room ID
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[0], b[0]);
        });

        // Initialize all rooms
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        // Count meetings in each room
        int[] maxMeet = new int[n];

        // Process meetings one by one
        for (int[] cur : meetings) {

            long start = cur[0];
            long end = cur[1];

            // Release rooms whose meetings have finished
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                long[] room = busy.poll();
                available.offer((int) room[1]);
            }

            long duration = end - start;
            int roomId;

            // Case 1: An available room exists
            if (!available.isEmpty()) {

                roomId = available.poll();

                busy.offer(new long[]{end, roomId});

            }

            // Case 2: All rooms are occupied
            else {

                long[] room = busy.poll();

                roomId = (int) room[1];

                // Delay meeting until room becomes free
                long newEndTime = room[0] + duration;

                busy.offer(new long[]{newEndTime, roomId});
            }

            maxMeet[roomId]++;
        }

        // Find room with maximum meetings
        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (maxMeet[i] > maxMeet[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}
