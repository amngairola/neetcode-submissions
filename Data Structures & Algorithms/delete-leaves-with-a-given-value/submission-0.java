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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;

        deleteLeafs(root, target);
       

        if (root.val == target && isLeaf(root)) {
            return null;
        }

        return root;
    }

   TreeNode deleteLeafs(TreeNode root, int target) {
        if (root == null)
            return null;

        TreeNode left = deleteLeafs(root.left, target);

        if (left != null && isLeaf(left ) && left.val == target) {
            root.left = null;
        }
        TreeNode right = deleteLeafs(root.right, target);
        if (right != null && isLeaf(right) && right.val == target) {
            root.right = null;
        }

        return root;
    }

    boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null)
            return true;
        return false;
    }
}