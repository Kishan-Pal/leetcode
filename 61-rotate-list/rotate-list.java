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

    public Integer recursion(ListNode cur, int[] k, int deep, ListNode[] head){
        if(cur.next == null) {
            k[0] = k[0] % deep;
            if(k[0] == 0) return -1;
            cur.next = head[0];
            if(k[0] == 1) {
                head[0] = cur;
            }
            return 1;
        }
        int a = recursion(cur.next, k, deep+1, head);
        if(a == -1) return -1;
        if(a == 0) return 0;
        a = a + 1;
        if(a == k[0]) {
            head[0] = cur;
        }
        if(a == k[0] + 1) {
            cur.next = null;
            return 0;
        }
        return a;
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode[] newHead = new ListNode[1];
        if(head == null) return head;
        newHead[0] = head;
        int[] k1 = new int[1];
        k1[0] = k;

        int a = recursion(head, k1, 1, newHead);
        return newHead[0];

    }
}