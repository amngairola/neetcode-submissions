/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
    return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        HashMap<Node, Node> hs = new HashMap<>();
        Node newN = new Node(node.val);
        hs.put(node, newN);

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (Node nbr : n.neighbors) {
                if (!hs.containsKey(nbr)) {
                    hs.put(nbr, new Node(nbr.val));
                    q.offer(nbr);
                }
             hs.get(n).neighbors.add(hs.get(nbr));
            }
        }

        return hs.get(node);
    }
}