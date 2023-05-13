class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(6, head);
        ListNode p = sentinel;
        while (p != null && p.next!= null){ 
            // so when p == null, it returns false and wont evaluate p.next!= null, so p.next won't error when p is null
            if (p.val == p.next.val) {
                p.next = p.next.next;
            }
            else p = p.next;  // don't miss the else here, only when there's no duplicate with the current one, then can we move to the next node, otherwise don't re-assign p
        }
        return sentinel.next;
    }
}