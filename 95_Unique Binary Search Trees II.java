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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
        }

    public List<TreeNode> helper (int start, int end){
        List<TreeNode> resultList = new LinkedList<TreeNode>();
        if (start>end) {
            resultList.add(null);
        }
        for (int i=start; i<= end; i++){
            List<TreeNode> leftnode = helper(start, i-1); //List of all possible left node
            List<TreeNode> rightnode = helper(i+1, end); //List of all possible right node
            //cannot put TreeNode root = new TreeNode(i);  here because otherwise below for loop will repeatedly replace the same tree, so unable to generate all trees.
            for (TreeNode l: leftnode){
                for (TreeNode r:rightnode){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    resultList.add(root);
                }
            }
        }
    return resultList;
    }

}