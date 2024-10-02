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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre, cur, newHead = head;
        int v;
        pre = null;
        cur = head;
        while(cur.next != null ) {
            if(cur.val == cur.next.val) {
                v = cur.val;
                while(cur != null && cur.val == v) {
                    cur = cur.next;
                }
                if(cur == null) {
                    if(pre == null) {
                        newHead = null;
                        break;
                    }
                    pre.next = null;
                    break;
                }
            }
            else {
                if(pre == null) {
                    newHead = cur;
                    pre = cur;
                    cur = cur.next;
                }
                else {
                    pre.next = cur;
                    pre = pre.next;
                    cur = cur.next;
                }
            }
            

        }
        if(pre != null) {
            pre.next = cur;

        }
        else if(cur != null) {
            newHead = cur;
        }
        return newHead;
    }
}