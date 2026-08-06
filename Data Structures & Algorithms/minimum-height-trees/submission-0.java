class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(new ArrayList<>());
        }

        int[] inDig = new int[n];

        for (int[] edg : edges) {
            int u = edg[0];
            int v = edg[1];

            inDig[u]++;
            inDig[v]++;

            ls.get(u).add(v);
            ls.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDig[i] == 1) {
                q.add(i);
            }
        }
        int remainingNodes = n;
        while (remainingNodes > 2) {
            int size = q.size();

            remainingNodes -= size;
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                ArrayList<Integer> adj = ls.get(node);
                for (int nbr : adj) {
                    inDig[nbr]--;
                    if (inDig[nbr] == 1) {
                        q.offer(nbr);
                    }
                }
            }
        }

        List<Integer> ans = new LinkedList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }
        return ans;
    }
}