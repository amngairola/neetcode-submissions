class Solution {
    public void solve(char[][] board) {


       int n = board.length;
       int m = board[0].length;

       for(int i = 0; i<n ; i++){
            if(board[i][0] =='O' ){
                dfs(i , 0 , board);
            }
            if(board[i][m-1] =='O' ){
                dfs(i , m-1 , board);
            }
        }
        for(int j = 0 ; j<m ; j++){
            if(board[0][j] =='O' ){
                dfs(0 , j , board);
            }
            if(board[n-1][j] =='O' ){
                dfs(n-1 , j , board);
            }
       } 
        for(int i =0; i<n ; i++){
              for(int j = 0 ; j<m ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] ='X';
                }
           }
        }

        for(int i =0; i<n ; i++){
              for(int j = 0 ; j<m ; j++){
                if(board[i][j] == 'A'){
                    board[i][j] ='O';
                }
           }
        }
    }

    void dfs(int r , int c , char[][] arr){
         
        arr[r][c] = 'A';
        int[][] dir = {
            {-1 , 0},
            {1 , 0},
            {0 , -1},
            {0 , 1}
        };


        for(int x = 0; x<4 ; x++){
            int i = r+dir[x][0];
            int j = c+dir[x][1];

            if( i<0 || i >= arr.length || j<0 ||j >= arr[0].length 
            )continue;

            else if(arr[i][j] == 'O'){
                  arr[i][j] = 'A';
                  dfs(i , j , arr);
                 
            }

        }
        
    }
}
