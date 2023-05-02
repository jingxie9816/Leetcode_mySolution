class Solution {
    int maxD = 0; // outside of the function to keep track of the largest diameter
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        findMaxDepth(root);
        return maxD;
    }

    private int findMaxDepth(TreeNode root){
        if (root == null) return 0;
        int leftDepth = findMaxDepth(root.left);
        int rightDepth = findMaxDepth(root.right);
        maxD = Math.max(maxD, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}