class Solution {
    public int uniquePaths(int m, int n) {
        return findPaths(m, n);
    }

    int findPaths(int m, int n) {
        int[] prev = new int[n + 1];
        Arrays.fill(prev , 1);

        for (int i = 1; i < m; i++) {

            int[] cur = new int[n + 1];
            // cur[0] = 1;
            for (int j =1; j <= n; j++) {
                if (i == 0 && j == 0)
                    continue;
                // top
                int top = 0;
                if (i > 0)
                    top = prev[j];
                // (i - 1, j, m, n);

                // left

                int left = 0;
                if (j > 0)
                    left = cur[j - 1];

                // findPaths(i, j - 1, m, n);

                cur[j] = top + left;
            }
            prev = cur;
        }

        return prev[n];
    }
}
