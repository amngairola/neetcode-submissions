class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        boolean[][] vis = new boolean[n][m];

int cnt =0;
        for(int i = 0 ; i<n ; i++){
            for(int j = 0; j<m ; j++){
                if(grid[i][j]-'0' == 1 && !vis[i][j]){
                    dfs(i , j , grid , vis);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    void dfs(int i , int j , char[][] arr , boolean[][]vis){
        vis[i][j] = true;

        int[][] dir = {
            {-1 , 0},
            {1, 0},
            {0 , -1},
            {0 , 1}
        };

        for(int k = 0 ; k<4 ; k++){
            int r = i+dir[k][0];
            int c = j + dir[k][1];

            if(r < 0 || r>= arr.length || c < 0 || c>= arr[0].length)continue;

            else if(arr[r][c]-'0' == 1 && !vis[r][c]){
                dfs(r , c , arr ,vis);
            }
        }
    }
}
