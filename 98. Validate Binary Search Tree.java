class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;
        long preVal = Long.MIN_VALUE;

        while(!stack.isEmpty() || curr != null){
            while (curr != null) {
                stack.push(curr);
                curr = curr.left; //put all of the left most node to stack
            }
            // use stack because we need Last-In-First-Out, we put leftmost node lastly, and we need visit them first.

            curr = stack.pop(); // take out the first node (leftmost)
            if (curr.val <= preVal) return false;
            preVal = curr.val; //re-assign the smallest value (leftmost node)
            curr = curr.right; //visit right child node before go to parent node (next one in stack) - rule of Inorder
        }
        return true;
    }
}