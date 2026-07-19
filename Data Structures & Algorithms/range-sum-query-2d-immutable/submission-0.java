class NumMatrix {
    int[][] mat;

    HashMap<Integer , ArrayList<Integer>> mp = new HashMap<>();

    public NumMatrix(int[][] matrix) {
        mat = matrix;

        for(int i = 0; i<mat.length ; i++){
            mp.put(i, new ArrayList<Integer>());
            calCulateSum( i , mat , mp);
        }
    }

    void  calCulateSum( int row ,int[][] mat , 
    HashMap<Integer , ArrayList<Integer>> mp){

        int sum = 0;
       
        for(int i = 0 ; i<mat[row].length ; i++){
             
             
             sum+=mat[row][i];
             mp.get(row).add(sum);
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1 ; i<=row2 ; i++){
            int s = col1 ;
            int e = col2;

           int s1 =  (col1 == 0) ? 0 : mp.get(i).get(col1 - 1);
           int s2 =  mp.get(i).get(e);

          sum+=s2-s1;
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */