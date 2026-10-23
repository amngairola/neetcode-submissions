class Solution {
  
    public void setZeroes(int[][] matrix) {
        
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 ) {
                    dfsCol(j,  matrix );
                    dfsRow(i, matrix );
                   
                }
            }
        }


        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == -1) {
                  matrix[i][j] = 0;
                }
            }
        }
    }

        void dfsCol(int c , int[][] mat ){

            for(int i = 0 ; i< mat.length ; i++){
                if(mat[i][c] == 0)continue;
                mat[i][c] = -1;
               
            }
        }

        void dfsRow(int r , int[][] mat ){

              for(int i = 0 ; i< mat[0].length ; i++){
                if(mat[r][i] == 0)continue;
                mat[r][i]= -1;
                
            }
        }
}

    
