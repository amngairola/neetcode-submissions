class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            rev(mat[i]);
        }

        return;
    }

    void rev(int[] mat) {
        int i = 0, j = mat.length-1;

        while (i < j) {
            int temp = mat[i];
            mat[i] = mat[j];
            mat[j] = temp;
            i++;
            j--;
        }
    }
}
