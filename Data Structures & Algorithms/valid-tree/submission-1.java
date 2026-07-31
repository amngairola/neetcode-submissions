class Solution {
    public boolean validTree(int n, int[][] pre) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

       boolean[] vis = new boolean[n];
       for (int i = 0; i < pre.length; i++) {
            int u = pre[i][0];
            int v = pre[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        if(dfs( 0 ,-1 , adj , vis))return false;
            for (int i = 0; i < n; i++) {
                if(!vis[i])return false;  
            }
        return true;
    }

    boolean dfs(int cur , int parent ,  ArrayList<ArrayList<Integer>> adj , boolean[]vis){
        vis[cur] = true;

        for(int nbr : adj.get(cur)){

            if(vis[nbr] && nbr != parent){
                return true;
            }
            else if(!vis[nbr]){
                if(dfs(nbr , cur , adj , vis)) return true;
            }
        }

        return false;
    }



    
}

// class DSU{
//     int[] parent;
//     int[] size;

//     DSU{
//         parent = new int[n];
//         size = new int[n];

//         for(int i = 0 ; i<n ; i++){
//             parent[i] = i;
//         }
//     }

//     int find(int x){
//         if(parent[x] != x){
//             parent[x] = find(parent[x]);
//         }

//         return parent[x];
//     }

//     void union(int x , int y){
//         int px = find(x);
//         int py = find(y);

//         if(px == py) return;

//         if(size[px] < size[py]){
//            parent[px] = py;
//         }else if(size[px] > size[py]){
//             parent[py] = px;
//         }else{
//  parent[py] = px;
//  px++;
//         }
//     }
// }
