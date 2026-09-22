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
    boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

    int maxi;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        if (isLeaf(root)) {
            return root.val;
        }

        maxi = -(int) 1e9;
        sum(root);

        return maxi;
    }

    int sum(TreeNode root) {
        if (root == null)
            return 0;

       int left = Math.max(0, sum(root.left));
       int right = Math.max(0, sum(root.right));

        int path = root.val + left + right;
        maxi = Math.max(maxi, path);

        return root.val + Math.max(right, left);
    }
}
