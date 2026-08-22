/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// next = node || null
// random = node || null;

// 1  create copy node with next pointer and keep it as node.next bwteen all nodes
// 2  node.nxt = copy node
// 3  node.next.next = orignal next node

// 4 copy random  , node.next.random = node.random.next  || null;

// 4 - saprate lists  - create newHead = head.next;
// t1 = newHead;
// t2 = head
// t1.next = t1.next.next || null;
// t2.next  = t2.next.next || null;

// 5-  return newHead;

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        // crete new cpy nodes

        if(temp == null) return null;
        
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }
        temp = head;
        // connect randoms
        while (temp != null && temp.next != null) {
            Node random = temp.random == null ? null : temp.random.next;
            temp.next.random = random;

            temp = temp.next.next;
        }

        // saprate list

        temp = head;
        Node newHead = temp.next;
        Node t1 = newHead;

        while (temp != null && temp.next != null) {
            temp.next = temp.next.next;
            t1.next = temp.next == null ? null : temp.next.next;

            temp = temp.next;
            t1 = t1.next;
        }
        return newHead;
    }
}
