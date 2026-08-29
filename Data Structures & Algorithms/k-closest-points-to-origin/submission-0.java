class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a, b) -> Integer.compare(
        (b[0] * b[0] + b[1] * b[1]),
        (a[0] * a[0] + a[1] * a[1])
    )
);

        for(int[] n :  points){
            pq.offer(n);
            if(pq.size() > k) pq.poll();
        }

        int[][] ans = new int[pq.size()][2];
        int i =0;
        while(!pq.isEmpty()){
            int[] cur  = pq.poll();
            ans[i++] = cur;
        }

        return ans;
    }
}
