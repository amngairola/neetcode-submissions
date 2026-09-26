/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<TreeNode, int[]> dp;
    public int rob(TreeNode root) {
        dp = new HashMap<>();

        int[] ans = solve(root);

        return Math.max(ans[0], ans[1]);
    }

    int[] solve(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }

        if (dp.containsKey(root))
            return dp.get(root);

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int np = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        int p = left[0] + right[0] + root.val;

        int[] ans = new int[] {np, p};

        dp.put(root, ans);

        return ans;
    }
}