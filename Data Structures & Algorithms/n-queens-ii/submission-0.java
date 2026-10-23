class Solution {

    HashSet<List<String>> ans;
    int n;
    public int totalNQueens(int n) {
        
  
        this.n = n;
        char[][] board = new char[n][n];
        ans = new HashSet<>();

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        place(0, board);

        return ans.size();
    }

    void place(int c, char[][] board) {

        if (c >= n) {
            addToAns(board);
            return;
        }

        for (int i = 0; i < n; i++) {

            if (canPlace(i, c, board)) {
                board[i][c] = 'Q';

                place(c + 1, board);

                board[i][c] = '.';
            }
        }
    }

    void addToAns(char[][] board) {

        List<String> ls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }

            ls.add(sb.toString());
        }

        ans.add(ls);
    }

    boolean canPlace(int r, int c, char[][] board) {

        int i = r;
        int j = c;

        // Check left
        while (j >= 0) {
            if (board[i][j] == 'Q') return false;
            j--;
        }

        // Check upper-left diagonal
        i = r;
        j = c;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        // Check lower-left diagonal
        i = r;
        j = c;

        while (i < n && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i++;
            j--;
        }

        return true;
    }
}