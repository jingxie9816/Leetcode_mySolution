class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode sentinel = new ListNode(666, head);
        ListNode curr = sentinel;
        // DON'T compare curr.val and curr.next.val, DO compare curr.next.val and curr.next.next.val because need to stand at the non-duplicate node and look forward.
        while(curr.next != null && curr.next.next != null){
            if (curr.next.val == curr.next.next.val){
                int check = curr.next.val;
                while (curr.next != null && curr.next.val == check){
                    curr.next = curr.next.next;
                    }
            }
            else curr = curr.next;
        }
    return sentinel.next;
    }
}