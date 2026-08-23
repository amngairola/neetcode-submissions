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
    public ListNode addTwoNumbers(ListNode r1, ListNode r2) {
        if (r1 == null)
            return r2;
        if (r2 == null)
            return r1;

        

        ListNode t1 = r1;
        ListNode t2 = r2;

        ListNode newHead = new ListNode(-1);
        ListNode t3 = newHead;

        int carry = 0;

        while (t1 != null || t2 != null || carry != 0) {
            int sum = carry;
            // t1
            if (t1 != null) {
                sum += t1.val;
                t1 = t1.next;
            }

            // t2
            if (t2 != null) {
                sum += t2.val;
                t2 = t2.next;
            }

            carry = sum / 10;
            t3.next = new ListNode(sum % 10);
            t3 = t3.next;
        }

        ListNode result = rev(newHead.next);
        
        return rev(result);
    }

    ListNode rev(ListNode head) {
        ListNode t1 = head;
        ListNode prev = null;

        while (t1 != null) {
            ListNode next = t1.next;
            t1.next = prev;

            prev = t1;
            t1 = next;
        }

        return prev;
    }
}
