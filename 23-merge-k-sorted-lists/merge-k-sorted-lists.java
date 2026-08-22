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
    public ListNode mergeKLists(ListNode[] list) {
        if(list.length == 0) return null;
        ArrayList<ListNode> arr = new ArrayList<>();
        for(ListNode n : list) arr.add(n);
        while(arr.size()>1) {
            ListNode a = arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            ListNode b = arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            ListNode c = merge(a,b);
            arr.add(c);
        }
        return arr.get(0);
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode i = l1;
        ListNode j = l2;
        ListNode t = new ListNode(-1);
        ListNode k = t;
        while (i != null && j != null) {
            if (i.val <= j.val) {
                k.next = i;
                i = i.next;
            } else {
                k.next = j;
                j = j.next;
            }
            k=k.next;
        }
        if(i==null) k.next = j;
        else k.next = i;
        return t.next;
    }
}