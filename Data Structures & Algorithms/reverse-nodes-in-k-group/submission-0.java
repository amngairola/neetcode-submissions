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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;

        ListNode temp = head;

        ListNode l = null;
        ListNode r = null;
        while (temp != null) {
            // find kth node;
            ListNode bp = temp;

            int i = 1;
            while (temp != null && i < k) {
                temp = temp.next;
                i++;
            }

            if ( temp == null) {
                if (l != null) {
                    l.next = bp;
                }
                break;
            }
            r = temp.next ;
            temp.next = null;
            ListNode revHead = rev(bp);

            if (newHead == null) {
                newHead = revHead;
            } else {
                l.next = revHead;
            }
            bp.next = r;
            l = bp;
            temp = bp.next;
        }

        return newHead;
    }

    ListNode rev(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
