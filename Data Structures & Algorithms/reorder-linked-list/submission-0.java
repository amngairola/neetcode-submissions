/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        
        if (head == null || head.next == null) return;
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;

        while(temp!= null){
            st.push(temp);
            temp = temp.next;
        }

        temp = head;

        while(!st.isEmpty())    {
           
           ListNode nxt = st.pop();

           if (temp == nxt || temp.next == nxt) {
                temp.next = nxt;
                nxt.next = null;
                break;
            }
            nxt.next = temp.next;
            temp.next = nxt;

            temp = temp.next.next;
        }
    }
}
