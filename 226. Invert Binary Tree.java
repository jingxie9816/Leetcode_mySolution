/*DFS(Recursion)*/
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


/*BFS*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            curr.left = right;
            curr.right = left;
            if(curr.left != null) {
                queue.offer(curr.left);
                }
            if (curr.right != null){
                queue.offer(curr.right);
            }
        } return root;
    }
}