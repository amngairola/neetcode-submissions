class Solution {
    public boolean isValidSudoku(char[][] board) {
        return make(0, 0, board);
    }

    boolean make(int r, int c, char[][] board) {
        

        for (int i = r; i < board.length; i++) {
            for (int j = c; j < board[0].length; j++) {

                if(board[i][j] != '.')
                {

                int num = board[i][j] - '0';
                    // check row
                    if (!isSafeRow(i, j, board, num))
                        return false;
                    if (!isSafeCol(i, j, board, num))
                        return false;
                    if (!isSafeBox(i, j, board, num))
                        return false;

                    
                }
            }
        }

        return true;
    }

    boolean  isSafeRow(int i , int j , char[][] arr , int cur){

            for(int col = 0 ; col < arr[0].length ; col++){
                if( col != j && arr[i][col]-'0' == cur) return false;
            }
            return true;
    }
     boolean  isSafeCol(int i , int j , char[][] arr , int cur){
           for(int col = 0 ; col < arr.length ; col++){
                if(col != i &&arr[col][j]-'0' == cur) return false;
            }
            return true;
    }
     boolean  isSafeBox(int i , int j , char[][] arr , int cur){
        
        int sr = (i/3)*3;
        int sc = (j/3)*3;

        for(int r = sr ; r < sr+3 ; r++){
            for(int c = sc ; c <sc+3 ; c++){
                if(  r != i && c !=j && arr[r][c]-'0' == cur)return false;
            }
        }
        return true;
    }
}
