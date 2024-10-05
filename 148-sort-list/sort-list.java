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
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }
    public ListNode sort(ListNode start, ListNode end) {
        if(start == end || start == null || start.next == null) return start;
        ListNode pre, cur, cur2;
        cur = start;
        cur2 = start;
        pre = null;
        while(cur2 != null && cur2.next != null) {
            pre = cur;
            cur = cur.next;
            cur2 = cur2.next.next;
        }
        pre.next = null;
        ListNode head1 = sort(start, pre);
        ListNode head2 = sort(cur, cur2);
        ListNode head = new ListNode(10101010);
        cur = head1;
        cur2 = head2;
        pre = head;
        while(cur != null && cur2 != null) {
            if(cur.val < cur2.val) {
                pre.next = cur;
                cur = cur.next;
            }
            else {
                pre.next = cur2;
                cur2 = cur2.next;

            }
            pre = pre.next;
        }
        if(cur != null) {
            pre.next = cur;
            cur = cur.next;
            pre = pre.next;
        }
        if(cur2 != null) {
            pre.next = cur2;
            cur2 = cur2.next;
            pre = pre.next;
        }
        return head.next;
    }
}