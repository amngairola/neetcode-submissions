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
     ArrayList<TreeNode> roots ;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        roots = new ArrayList<>();
        findRoot(root, subRoot);

        if (roots.size() == 0)
            return false;


            for(TreeNode r : roots){
                if(checkIsSame(r, subRoot))return true;
            }
        return false;
    }

    boolean checkIsSame(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return true;

        if (r1 == null || r2 == null)
            return false;

        if (r1.val != r2.val)
            return false;

        boolean left = checkIsSame(r1.left, r2.left);
        if (!left)
            return false;

        boolean right = checkIsSame(r1.right, r2.right);
        if (!right)
            return false;

        return true;
    }

    void findRoot(TreeNode root, TreeNode r2) {
        if (root == null)
            return;

        if (root.val == r2.val){
            roots.add(root);
            }

       findRoot(root.left, r2);
       findRoot(root.right, r2);

       

      
    }
}
