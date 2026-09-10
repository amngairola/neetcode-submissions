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
    public boolean isValidBST(TreeNode root) {
        return validate(root, -(int) 1e9, (int) 1e9);
    }

    boolean validate(TreeNode root, int mini, int maxi) {
        if (root == null)
            return true;

        if (root.val <= mini || root.val >= maxi) {
            return false;
        }

        if (root.left != null) {
            if (!validate(root.left, mini, root.val))
                return false;
        }

        if (root.right != null) {
            if (!validate(root.right, root.val, maxi))
                return false;
        }

        return true;
    }
}

// let left = f(node.left.val < node.val )
// if(!left) return false;

// let right =  f(node.val < node.right.val)

//  return left && right;
// root=[0,-1000,1000,null,null,0]
