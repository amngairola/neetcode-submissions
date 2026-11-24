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

        return solve(root, true);
    }

    int solve(TreeNode root, boolean canPick) {
        if (root == null)
            return 0;

        if (dp.containsKey(root)) {
            return dp.get(root)[canPick ? 1 : 0];
        }

        int np = solve(root.left, true) + solve(root.right, true);

        int p = 0;

        if (canPick) {
            p = root.val + solve(root.left, false) + solve(root.right, false);
        }

        dp.put(root, new int[] {np, Math.max(p, np)});
        return canPick ? Math.max(p, np) : np;
    }
}