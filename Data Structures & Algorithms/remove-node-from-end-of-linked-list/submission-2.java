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
    public ListNode removeNthFromEnd(ListNode head, int n) {


            
            ListNode fast  = head;
            ListNode slow = head;

            if(head == null || head.next == null) return null;

            while(n>0 && fast != null ){
                fast = fast.next;
                n--;
            }

           if(fast == null){
            slow = slow.next;
            return slow;
           }
            
            while(fast != null && fast.next != null ){
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next != null ? slow.next.next : null;

            return head;
    }
}
