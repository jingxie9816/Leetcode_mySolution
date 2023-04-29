class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(666, head);
        ListNode largeHead = new ListNode(999, head);
        ListNode small = smallHead;
        ListNode large = largeHead;

        while (head != null){
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }
            if (head.val >= x){
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next; 
        return smallHead.next;
    }
}