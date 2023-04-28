class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left); // invert left child tree
        TreeNode right = invertTree(root.right);// invert right child tree
        root.left = right;
        root.right = left;
        return root;
    }
}