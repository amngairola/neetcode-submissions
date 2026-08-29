class KthLargest {

    PriorityQueue<Integer> pq ;
    int k ;
   
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a , b) -> b-a);

        this.k = k;
        

        for(int n : nums){
            pq.offer(n);
        }
    }
    
    public int add(int val) {
        
        pq.offer(val);
        Stack<Integer> st = new Stack<>();

        int x = k;
        while(x > 1){
            st.push(pq.poll());
            x--;
        }

        int ans = pq.poll();
        while(!st.isEmpty()){
           pq.offer(st.pop());
        }
        pq.offer(ans);

        return ans;
    }
}
