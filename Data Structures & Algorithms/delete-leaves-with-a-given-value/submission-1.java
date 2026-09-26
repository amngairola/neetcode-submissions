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

    boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;


        if(root.val == target && isLeaf(root))return null;

        TreeNode left = removeLeafNodes(root.left , target);
        TreeNode right = removeLeafNodes(root.right , target);

        root.left = left;
        root.right = right;

        if(root.val == target && isLeaf(root))return null;  
           
        return root;
    }
}