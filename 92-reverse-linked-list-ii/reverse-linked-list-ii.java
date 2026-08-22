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
    public ListNode reverse(ListNode head) {
        ListNode pr = null;
        ListNode fr = null;
        ListNode crr = head;
        while(crr != null) {
            fr = crr.next;
            crr.next = pr;
            pr = crr;
            crr= fr;
        }
        return pr;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        dummy.next = head;
        for(int i=1;i<=left-1;i++) {
            temp = temp.next;
        }
        ListNode tail1 = temp;
        ListNode head2 = temp.next;
        for(int i=1;i<=right-left+1;i++) {
            temp = temp.next;
        }
        ListNode tail2 = temp;
        ListNode head3 = temp.next;
        tail1.next = null;
        tail2.next = null;
        reverse(head2);
        tail1.next = tail2;
        head2.next = head3;
        return dummy.next;
        // ArrayList<ListNode> arr = new ArrayList<>();
        // ListNode temp = head;
        // while (temp != null) {
        //     arr.add(temp);
        //     temp = temp.next;
        // }
        // int i = left-1,j=right-1;
        // while(i<j) {
        //     ListNode t1 = arr.get(i);
        //     ListNode t2 = arr.get(j);
        //     arr.set(i,t2);
        //     arr.set(j,t1);
        //     i++;
        //     j--;
        // }
        // for(i=0;i<arr.size();i++) {
        //     arr.get(i).next = (i==arr.size()-1) ?  null : arr.get(i+1);
        // }
        // return arr.get(0);
    }
}