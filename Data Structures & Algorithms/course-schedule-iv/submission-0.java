class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses, int[][] prer, int[][] queries) {

            return canFinish(numCourses , prer ,queries);
        }

    public List<Boolean> canFinish(int num, int[][] pre , int[][] queries) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDigri = new int[num];

        for (int i = 0; i < pre.length; i++) {
            int u = pre[i][0];
            int v = pre[i][1];

            inDigri[v]++;
            adj.get(u).add(v);
        }

        Queue<Integer> q = new LinkedList<>();

      
      
        for (int i = 0; i < num; i++) {
            if (inDigri[i] == 0)
                q.offer(i);
            
            
        }

        
        int cnt = 0;
        List<HashSet<Integer>> preSet = new ArrayList<>();
        for (int i = 0; i < num; i++) preSet.add(new HashSet<>());
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            
            cnt++;

            for (int nbr : adj.get(cur)) {
                preSet.get(nbr).add(cur);
                preSet.get(nbr).addAll(preSet.get(cur));
                inDigri[nbr]--;
                if (inDigri[nbr] == 0)
                    q.offer(nbr);
            }
        }


 List<Boolean>  ans = new ArrayList<>();
       for(int[] qry : queries){
        int u = qry[0];
        int v = qry[1];
        if(preSet.get(v).contains(u)){
            ans.add(true);

        }else{
             ans.add(false);
        }
       }

        return ans;
    }
}