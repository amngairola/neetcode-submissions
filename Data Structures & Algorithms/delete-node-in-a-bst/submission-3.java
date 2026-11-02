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
        
        // Base case: If the tree is empty, the key is not found.
        if (root == null) {
            return null;
        }
        
        // **FIX:** Use an if / else if / else structure for searching.
        if (key < root.val) {
            // The key is in the left subtree.
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // The key is in the right subtree.
            root.right = deleteNode(root.right, key);
        } else {
            // This is the node to be deleted (key == root.val).

            // Case 1 & 2: Node has 0 or 1 child.
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node has two children.
            // Find the in-order successor (smallest node in the right subtree).
            TreeNode successor = findSuccessor(root.right);
            
            // Copy the successor's value to this node.
            root.val = successor.val;
            
            // Delete the original successor node from the right subtree.
            root.right = deleteNode(root.right, successor.val);
        }
        
        return root;
    }

    // **FIX:** Corrected typo in function name.
    private TreeNode findSuccessor(TreeNode node) {
        TreeNode current = node;
        // The successor is the leftmost node in this subtree.
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }
}