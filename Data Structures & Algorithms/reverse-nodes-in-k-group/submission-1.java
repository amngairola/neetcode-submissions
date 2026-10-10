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
        ListNode temp = head;
        ListNode newHead = null;

        ListNode prev = temp;
     
        ListNode r;
        while (temp != null) {
            ListNode kth = findK(temp, k);

            if (kth == null) {
                // l.next = temp;
                break;
            }
            r = kth.next;
            kth.next = null;
            ListNode revH = revK(temp);

            if (newHead == null) {
                newHead = revH;
                
            } else {
                prev.next = revH;

            }
            temp.next = r;
            prev = temp;
            temp = r;
        }

        return newHead;
    }

    ListNode findK(ListNode node, int k) {
        ListNode temp = node;
        int cnt = 1;

        while (cnt < k && temp.next != null) {
            temp = temp.next;
            cnt++;
        }
        if(cnt != k ) return null;
        return temp;
    }

    ListNode revK(ListNode node) {
        ListNode temp = node;
        ListNode prev = null;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
