class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        if (head.next == null) return head;
        ListNode pre = null;
        ListNode curr = head;
        ListNode aft = head.next;
        while (aft!= null){
        curr.next = pre;
        pre = curr;
        curr = aft;
        aft = aft.next;
        }
        curr.next = pre;
        return curr;
    }
}