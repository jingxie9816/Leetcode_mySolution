class Solution {
    private ListNode frontNode; // variable outside of the recursion to track the frontNode

    private boolean check(ListNode currnetNode){
        //base case
        if (currnetNode == null) return true;
        if (!check(currnetNode.next)) return false; //check whether next node is Palindrome, if false, !false = true, if statement is ture, return false;
        // if next node is palindrome, check whether currnetNode = frontNode. 
        if (currnetNode.val != frontNode.val) return false; // when first time reach here, frontNode is the first node of head
        frontNode = frontNode.next; //if frontNode(first node) matches the last node, then forward to second node.
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        // recursion
        frontNode = head;
        return check(head);

    }
}