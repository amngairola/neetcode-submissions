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
    static int cnt ;
    public int goodNodes(TreeNode root) {
        cnt = 0;

        checkH(root , -(int)1e9);
        return cnt;
    }

    void checkH(TreeNode root , int maxi){
        if(root == null){
            return ;
        }


        if(root.val >= maxi)
        {
            cnt++;
        }

        checkH(root.left , Math.max(maxi , root.val));
        checkH(root.right, Math.max(maxi , root.val));


        
        return ;
    }
}
