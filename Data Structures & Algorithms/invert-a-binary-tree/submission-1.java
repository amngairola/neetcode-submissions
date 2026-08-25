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
    public TreeNode invertTree(TreeNode root) {
        inOrder(root);
        return root;
    }
    TreeNode  inOrder(TreeNode root ){
       if(root == null)return null ;

       TreeNode left  = inOrder(root.left);
        
       TreeNode right = inOrder(root.right);

       root.right = left;
       root.left = right;

        return root;
    }
}
