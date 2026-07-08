class Solution {
    
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int totel = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    totel += 4;

                    for (int k = 0; k < 4; k++) {
                        int r = i + dr[k];
                        int c = j + dc[k];
                        if (r >= 0 && r < grid.length &&
                         c >= 0 && c < grid[0].length
                        && grid[r][c] == 1 ) {
                            totel--;
                        }
                    }
                }
            }
        }

        return totel;
    }

   
}