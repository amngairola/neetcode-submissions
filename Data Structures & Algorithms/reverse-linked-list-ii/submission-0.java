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
    public ListNode reverseBetween(ListNode head, int l, int r) {
        if (head == null || l == r) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        for (int i = 1; i < l; i++) {
            prev = cur;
            cur = cur.next;
        }
        ListNode leftN = cur;

        for (int i = l; i < r; i++) {
            cur = cur.next;
        }

        ListNode rightN = cur;

        ListNode afterRight = rightN.next;

        rightN.next = null;

        ListNode revHead = rev(leftN );

        if (prev == null) {
            head = revHead;
        } else {
            prev.next = revHead;
        }

        leftN.next = afterRight;

        return head;
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