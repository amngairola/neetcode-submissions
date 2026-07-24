class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // cell should be at bottom left || top right;

        // largest number in the col
        //

        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();

        boolean[][] p = new boolean[n][m];
        boolean[][] a = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(i, 0, heights, p);
            dfs(i, m - 1, heights, a);
        }
        for (int j = 0; j < m; j++) {
            dfs(0, j, heights, p);
            dfs(n - 1, j, heights, a);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && a[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    void dfs(int r, int c, int[][] arr, boolean[][] p) {
        p[r][c] = true;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int x = 0; x < 4; x++) {
            int i = r + dir[x][0];
            int j = c + dir[x][1];

            if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length)
                continue;

            else if (arr[i][j] >= arr[r][c] && !p[i][j]) {
                dfs(i, j, arr,  p);
            }
        }
        return;
    }
}
