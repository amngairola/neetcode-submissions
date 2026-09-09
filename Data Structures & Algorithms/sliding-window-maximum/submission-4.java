class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return nums;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int i = 0;

        int max = 0;

        for (int j = 0; j < nums.length; j++) {
            pq.offer(new int[]{nums[j] , j});

            if (j - i + 1 >= k) {
                while( !pq.isEmpty() && pq.peek()[1] < i){
                    pq.poll();
                }
                int[] cur = pq.peek();

                if (i < n) {
                     i++;
                }

                ans.add(cur[0]);
            }
        }
        int[] res = new int[ans.size()];

        for (int x = 0; x < res.length; x++) {
            res[x] = ans.get(x);
        }
        return res;
    }
}
