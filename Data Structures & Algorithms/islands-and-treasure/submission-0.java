class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        int n= grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i< n ;i++){
            for(int j  = 0; j<m ;j++){

                if(grid[i][j] == 0){
                    dfs(i , j , grid ,0);
                }
            }
        }
    }

    void dfs(int r , int c , int[][] grid , int dist){

        int[][] dir = {
            {-1 , 0},
            {1 , 0},
            {0 , -1},
            {0 , 1},
        };

        for(int k = 0; k< 4 ; k++){
            int i = r +dir[k][0];
            int j = c + dir[k][1];
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
    continue;
}

            if (grid[i][j] == -1 || grid[i][j] == 0) {
                continue;
            }

                if( grid[i][j] > dist + 1){
                    grid[i][j] = dist + 1;
                    dfs(i , j , grid , dist+1);
                }
            
        }
    }
}
