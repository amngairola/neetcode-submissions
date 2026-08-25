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
    List<Integer> ans ;
    public List<Integer> postorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        inOrder(root);
        return ans;
    }
    
    void inOrder(TreeNode root ){
        if(root == null)return ;

        inOrder(root.left);
        
        inOrder(root.right);
        ans.add(root.val);
    }
}