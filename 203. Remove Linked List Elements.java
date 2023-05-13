class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(666,head);
        ListNode p = sentinel;
        while (p.next != null){
            if (p.next.val == val) {
                p.next = p.next.next;
            }
            else p = p.next;
        }
        return sentinel.next;
    }
}