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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return inOrder(root, p.val, q.val);
    }

    TreeNode inOrder(TreeNode root, int p, int q) {
        if (root == null)
            return null;

        TreeNode right = null;
        TreeNode left = null;

        if (root.val > p && root.val > q) {
            left = inOrder(root.left , p , q);
        } else if (root.val < p && root.val < q) {
            right = inOrder(root.right , p , q);
        } else
            return root;

        return right == null ? left : right;
    }
}
