class Solution {
    class Pair {
        int r ;
        int c;

        Pair(int r , int c){
            this.r = r;
            this.c = c;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[image.length][image[0].length];

        q.offer(new Pair(sr , sc));

        vis[sr][sc] = true;

        int[][] dir = {
            {-1 , 0} , {1 , 0} ,{0 , -1} , {0 , 1}
        };
        int nodecolor = image[sr][sc];

        while(!q.isEmpty()){

            Pair node = q.poll();

            image[node.r][node.c] = color;
            vis[node.r][node.c] = true;

            for(int i = 0; i<4  ; i++){
                int r = node.r + dir[i][0];
                int c = node.c + dir[i][1];
                
                if(r < 0 || r>=image.length ||  c < 0 || c>=image[0].length)continue;

                else if(!vis[r][c] && image[r][c] == nodecolor){
                    q.add(new Pair(r , c));
                   
                }
            }
        }

        return image;
    }
}