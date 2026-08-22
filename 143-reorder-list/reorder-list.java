class Solution {

    public ListNode reverse(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {

            ListNode fwd = curr.next;

            curr.next = prev;
            prev = curr;
            curr = fwd;
        }

        return prev;
    }

    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return;

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Split
        ListNode head2 = slow.next;
        slow.next = null;

        // 3. Reverse second half
        head2 = reverse(head2);

        // 4. Merge
        ListNode first = head;
        ListNode second = head2;

        while(first != null && second != null) {

            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;

            first = next1;
            second = next2;
        }
    }
}