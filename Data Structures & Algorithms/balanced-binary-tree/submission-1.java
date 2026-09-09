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

    static boolean ans ;
    public boolean isBalanced(TreeNode root) {
       ans = true;

       checkH(root);
       return ans; 
    }


    int checkH(TreeNode root){
        if(root == null){
            return 0;
        }


        int left = checkH(root.left);
        int right = checkH(root.right);


        if(Math.abs(left - right) > 1){
            ans = false;
            return -1;
        }

        return 1+Math.max(left, right);
    }
}
