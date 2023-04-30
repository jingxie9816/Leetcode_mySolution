class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {return head;}
        ListNode sentinel = new ListNode(666, head);
        ListNode prev = sentinel;
        ListNode curr = head;
        for (int i = 1; i<left; i++){
            prev = prev.next;
            curr = curr.next;
            
        }
        ListNode firstTail = prev;
        ListNode midTail = curr;
        ListNode aft = curr.next;
        for (int i = left; i <= right; i++){
            curr.next = prev;
            prev = curr;
            curr = aft;
            if (aft != null) aft = curr.next;
        }

        firstTail.next = prev;
        midTail.next = curr;
        return sentinel.next;
    }
}