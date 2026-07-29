class Solution {
    public boolean canFinish(int num, int[][] pre) {
        

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < num; i++){
            adj.add(new ArrayList<>());
        }

        int[] inDigri = new int[num];


        for(int i =0 ; i<pre.length  ; i++){

            int u  = pre[i][0];
            int v = pre[i][1];

            inDigri[u]++;
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        

        for(int i = 0; i < num; i++){
            if(inDigri[i] == 0) q.offer(i);
         }

         if(q.isEmpty()) return false;
int cnt = 0;
         while(!q.isEmpty()){

            int cur = q.poll();
            cnt++;

            for(int nbr : adj.get(cur)){

                inDigri[nbr]--;
                if(inDigri[nbr] == 0)q.offer(nbr);
               
            }

         }


        return cnt == num;
    }
}
