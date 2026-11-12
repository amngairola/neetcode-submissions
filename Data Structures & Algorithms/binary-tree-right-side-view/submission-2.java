
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ls = new ArrayList<>();

        if (root == null) return ls;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Last node of current level
                if (i == size - 1) {
                    ls.add(node.val);
                }

                // Add children
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return ls;
    }
}
