class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int length = length(head);
        int t = k % length;
        if (t==0 || t== length) return head;
        ListNode tail = head;
        ListNode newtail = head;
        ListNode newhead;
        while(tail.next !=null){
            tail = tail.next;
        }
        tail.next = head;

        for (int i=0; i<length-t-1; i++){
            newtail = newtail.next;
        }
        // newhead points to where we break the old link; 
        newhead = newtail.next;
        newtail.next = null;
        return newhead;  // DON'T return the old 'head', which still points to the old head who might be in the middle now
    }

    public int length(ListNode head){
        int count = 0;
        while(head != null) {
            head = head.next;
            count++;
        } return count;
    }
}