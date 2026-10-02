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

    int n;
    int ans ;
    public int kthSmallest(TreeNode root, int k) {
            n = k;
            ans = 0;

            solve(root );
            return ans;
    }

    void solve(TreeNode root){
        if(root == null) return;

        solve(root.left);
        //cur
        n-=1;
        if(n == 0){
            ans = root.val;
        }
        solve(root.right);
    }
}
