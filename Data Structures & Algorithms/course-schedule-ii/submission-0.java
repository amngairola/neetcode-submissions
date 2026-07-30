class Solution {
    public int[] findOrder(int num, int[][] pre) {
        
        ArrayList<Integer> ans =  canFinish(num , pre);
        int n = ans.size();
        if(n == 0) return new int[0];

        int[] res = new int[n];

        for(int i = 0; i<n ; i++){
            res[i] = ans.get(i);
        }

        return res;
    }
     public ArrayList<Integer> canFinish(int num, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDigri = new int[num];

        for (int i = 0; i < pre.length; i++) {
            int u = pre[i][0];
            int v = pre[i][1];

            inDigri[u]++;
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();


        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if (inDigri[i] == 0)
                q.offer(i);
                ans.add(i);
        }

        if (q.isEmpty())
            return new ArrayList<>();
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            cnt++;

            for (int nbr : adj.get(cur)) {
                inDigri[nbr]--;
                if (inDigri[nbr] == 0)
                    q.offer(nbr);
            }
        }

       if(cnt != num){
       return new ArrayList<>();
       }

        return ans;
    }
}
