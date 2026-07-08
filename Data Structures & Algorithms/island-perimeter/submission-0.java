class Solution {

    static int totel;
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        totel = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ( !vis[i][j] && grid[i][j] == 1) {
                     bfs(grid, i, j, vis);
                }
            }
        }

        return totel;
    }

    void bfs(int[][] arr, int i, int j, boolean[][] vis) {

        vis[i][j] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int k = 0 ; k<4 ; k++){

            int r = i + dr[k] ;
            int c = j + dc[k] ;

            if(r < 0 || r>=arr.length ||  c < 0 ||  c>=arr[0].length
             || arr[r][c] == 0){
                totel++;
            }
            else if( r >= 0 && r<arr.length && c >=0 && c<arr[0].length &&
             arr[r][c]  == 1 && !vis[r][c]){
                bfs( arr , r , c , vis);

            }

        }

        
    }
}