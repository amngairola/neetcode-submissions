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

public class Codec {
    // Encodes a tree to a single string.

    StringBuilder sb;
    public String serialize(TreeNode root) {
        sb = new StringBuilder();

        dfs(root);

        return sb.toString();
    }

    void dfs(TreeNode node) {
        if (node == null) {
            sb.append(-1);
            return;
        }

        sb.append(node.val).append(',');

        if (node.left == null)
            sb.append(-1).append(',');
        else
            dfs(node.left);

        if (node.right == null)
            sb.append(-1).append(',');
        else
            dfs(node.right);
    }

    // Decodes your encoded data to tree.
    TreeNode root;
    String[] s;
    int i ;
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        root = null;

         s = data.split(",");
         i =0;
        return dfs();
    }

    TreeNode dfs() {
        if (i >= s.length) {
            return null;
        }

        
        int val = Integer.parseInt(s[i]);
        TreeNode root = val == -1 ? null : new TreeNode(val);
        if(root ==  null) return root;

        i+=1;
        root.left = dfs();
        i+=1;
        root.right = dfs();

        return root;
    }
}
