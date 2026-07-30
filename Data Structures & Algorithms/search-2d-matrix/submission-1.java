class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        if (target < mat[0][0] || target > mat[n - 1][m - 1])
            return false;

        int rowNum = bsearchCol(m - 1, 0, n - 1, mat, target);

        int s = 0;
        int e = m - 1;

        return bsearchRow(rowNum, s, e, mat, target);
    }
    boolean bsearchRow(int row, int s, int e, int[][] arr, int k) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (arr[row][mid] == k)
                return true;

            else if (arr[row][mid] > k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return false;
    }

    int bsearchCol(int col, int s, int e, int[][] arr, int k) {
        while (s < e) {
            int mid = s + (e - s) / 2;

            if (k <= arr[mid][col]) {
                e = mid;
            } else {
                s = mid+1;
            }
        }

        return s;
    }
}
