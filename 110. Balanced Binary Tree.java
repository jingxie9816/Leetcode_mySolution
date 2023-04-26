/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftheight = heightcounter(root.left);
        int rightheight = heightcounter(root.right);
        if (Math.abs(leftheight - rightheight) >1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }

    public int heightcounter(TreeNode root){
        if (root == null) return 0;
        return Math.max(heightcounter(root.left), heightcounter(root.right)) + 1;
    }
}