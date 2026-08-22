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
    public ListNode oddEvenList(ListNode head) {
        ListNode d1 = new ListNode(-1);
        ListNode d2 = new ListNode(-1);
        ListNode t1 = d1;
        ListNode t2 = d2;
        ListNode t = head;
        int idx = 1;
        while(t!=null) {
            if(idx % 2 == 1) {
                t1.next = t;
                t1 = t1.next;
            } else {
                t2.next = t;
                t2=t2.next;
            }
            idx++;
            t = t.next;
        }
        t1.next = d2.next;
        t2.next = null;
        return d1.next;
    }
}