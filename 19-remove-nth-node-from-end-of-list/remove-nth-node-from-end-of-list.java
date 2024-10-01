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

    public Integer recursion(ListNode cur, int deep, ListNode[] nextAddress, int n) {
        if(cur.next == null) {
            if(deep == n) {
                return -1;
            }
            if(n==2) {
                nextAddress[0] = cur;
            }
            return 1;
        }
        int a = recursion(cur.next, deep+1, nextAddress, n);
        if(a == -1) {
            return -1;
        }
        if(a == 0) return 0;
        a = a + 1;
        if(a == n-1) {
            nextAddress[0] = cur;
            return a;
        }
        if(a == n+1) {
            cur.next = nextAddress[0];
            return 0;
        }
        return a;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end, cur, next1;
        int i=0;
        if(n == 1) {
            if(head.next == null) {
                return null;
            }
            end = head;
            while((end.next).next != null) {
                end = end.next;
            }
            end.next = null;
            return head;
        }
        ListNode[] nextAddress = new ListNode[1];
        int a = recursion(head, 1, nextAddress, n);
        if(a == -1) return head.next;
        return head;

    }
}