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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
         if(root == null){
           
            return new TreeNode(val);
        }
     insertVal(root , val);
     return root;

    }


    void insertVal (TreeNode root , int val){
        if(root == null){
           
            return;
        }

        if(val < root.val){
           if(root.left != null) insertVal(root.left , val);
           else{ 
             root.left = new TreeNode(val);
             return;
            }

        }
        
        if(val > root.val){
            if(root.right  != null) insertVal(root.right , val);
            else{ 
             root.right = new TreeNode(val);
             return;
            }
        }
    }
}