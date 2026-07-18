class Solution {
    public int[] topKFrequent(int[] nums, int x) {
        
        // int n = nums.length;

       HashMap<Integer, Integer> mp = new HashMap<>();

       for(int n : nums){
        mp.put(n, mp.getOrDefault(n, 0)+1);
       }

       PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a , b)-> b[1]-a[1]
       );

       mp.forEach((k , v)->{
        pq.offer(new int[]{k , v});
       });

       int[] ans = new int[x];

       int i =0;

       while(!pq.isEmpty() && i <x){
        int[] cur = pq.poll();
        ans[i++] = cur[0];
       }
 return ans;
    }
}
