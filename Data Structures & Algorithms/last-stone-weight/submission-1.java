class Solution {
    public int lastStoneWeight(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> b-a);


         for(int n : nums){
            pq.offer(n);
        }

        while(!pq.isEmpty() && pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();

            if(a > b){
                pq.offer(a - b);
            } else if(b>a ){
                pq.offer(b - a);
            }
        }

        if(pq.isEmpty()) return 0;
        return pq.poll();
    }
}
