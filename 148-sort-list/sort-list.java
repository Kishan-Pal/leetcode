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
        ListNode cur = head, removed, pre, cur2;
        int temp;
        if(head == null) return null;
        while(cur.next != null) {
            if(cur.val > cur.next.val) {
                removed = cur.next;
                cur.next = cur.next.next;
                pre = null;
                cur2 = head;
                while(cur2 != null && cur2 != cur && cur2.val < removed.val) {
                    pre = cur2;
                    cur2 = cur2.next;

                }
                if(pre == null) {
                    removed.next = head;
                    head = removed;
                }
                else {
                    removed.next = pre.next;
                    pre.next = removed;
                }
                
            }
            else {

                cur = cur.next;
            }
        }
        return head;
    }
}