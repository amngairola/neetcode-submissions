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
    int maxi;
    boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null)
            return true;
        return false;
    }
    public int maxPathSum(TreeNode root) {
         maxi = -(int) 1e9;
        if (root == null)
            return 0;

        if (isLeaf(root)) {
            return root.val;
        }
        sum(root);

        return maxi;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        };

        int left = Math.max(0, sum(root.left));
        int right = Math.max(0, sum(root.right));

        int path = root.val + left + right;
        maxi = Math.max(path, maxi);

        return root.val + Math.max(left, right);
    }
}
