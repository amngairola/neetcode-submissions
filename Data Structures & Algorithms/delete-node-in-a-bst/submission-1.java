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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
         // if root = t
        if( root.val == key){
           

            TreeNode right = root.right;
            if(right == null) return root.left;
            TreeNode left  = root.left;
            if(left == null) return root.right;

            attachToLeft(right , left);

            return right;
        }

       root.left = deleteNode(root.left , key);
       root.right = deleteNode(root.right , key);

        
        return root;
    }


    TreeNode find( TreeNode  root , int val){
        if(root == null) return null;
        if(root.val == val) return root;

        TreeNode left = find(root.left , val);
        TreeNode right = find(root.right , val);

        if(left!=null) return left;

        return right;
    }

    void removeNode(TreeNode  root ){
         if(root == null) return;
         if(root.right == null){ 
                root = null;
                return;
            }
         root.val =  root.right.val ;
         root.left = root.right.left != null ? root.right.left  :null;
         removeNode(root.right);


    }

    void attachToLeft(TreeNode  root  , TreeNode left){

        while(root.left != null ){
            root  = root.left;
        }

       root.left = left;
    }
}