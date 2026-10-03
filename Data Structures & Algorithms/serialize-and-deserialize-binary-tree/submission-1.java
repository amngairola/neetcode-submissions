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

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (cur == null) {
                sb.append("#,");
                continue;
            }
            sb.append(cur.val).append(',');

            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] data = str.split(",");
        if (data[0].equals("#"))
            return null;

        int idx = 0;
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(data[idx++]));
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            String left = data[idx++];
            String right = data[idx++];

            if (!left.equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(left));
                q.offer(cur.left);
            }

            if (!right.equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(right));
                q.offer(cur.right);
            }
        }
        return root;
    }
}
