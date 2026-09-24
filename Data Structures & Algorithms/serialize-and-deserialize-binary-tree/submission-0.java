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
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null)
            return sb.toString();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        sb.append(root.val);
        sb.append(',');

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (cur.left == null)
                    sb.append(-1).append(',');
                else {
                    q.offer(cur.left);
                    sb.append(cur.left.val).append(',');
                }

                if (cur.right == null)
                    sb.append(-1).append(',');
                else {
                    q.offer(cur.right);
                    sb.append(cur.right.val).append(',');
                }
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty()) {
        return null;
         }

        String[] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();

        int rootVal = Integer.parseInt(arr[0]);
        TreeNode root = new TreeNode(rootVal);
        q.offer(root);

        int indx = 1;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            int lval = Integer.parseInt(arr[indx]);
            indx++;
            if (lval == -1) {
                cur.left = null;

            } else {
                cur.left = new TreeNode(lval);
                q.offer(cur.left);
            }
            
            int rval = Integer.parseInt(arr[indx]);
            indx++;
            if (rval == -1) {
                cur.right = null;

            } else {
                cur.right = new TreeNode(rval);
                q.offer(cur.right);
            }
        }

        return root;
    }
}
