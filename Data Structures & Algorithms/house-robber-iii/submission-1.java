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
        int[] ans = sum(root);
        return Math.max(ans[0], ans[1]); 
    }

    int[] sum(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }

        if (dp.containsKey(root))
            return dp.get(root);

        int[] left = sum(root.left);
        int[] right =sum(root.right);

        int notPick = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        int pick = root.val + left[0] + right[0];

        int[] result = new int[] {notPick, pick};

        dp.put(root, result);

        return result;
    }
}