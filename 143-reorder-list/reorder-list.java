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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head, temp;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        int n = stack.size();
        cur = head;
        for(int i=1; i<=(n/2)-1; i++) {
            temp = stack.pop();
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        if(n % 2 == 0) {
            temp = stack.pop();
            temp.next = null;
            cur.next = temp;
        }
        else {
            temp = stack.pop();
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
            cur.next = null;
        }
    }
}