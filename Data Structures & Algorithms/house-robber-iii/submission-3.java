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
    HashMap<TreeNode, int[]> dp;
    public int rob(TreeNode root) {
        dp = new HashMap<>();
        int[] ans = dfs(root);

        
        return Math.max(ans[0], ans[1]);
    }

    int[] dfs(TreeNode root) {
        if (root == null) {
            return  new int[]{0 ,0};
        }

        if (dp.containsKey(root)) {
            return dp.get(root);
        }

       

        int[] l = dfs(root.left);
        int[] r = dfs(root.right);

       int np =  Math.max( l[0] , l[1] ) + Math.max(r[0] , r[1]);

       

         int p = (l[0] + r[0]) + root.val;
        int[] ans = new int[] {np, p};
        dp.put(root, ans);
        return ans;
    }
}