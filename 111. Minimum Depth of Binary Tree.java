class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int result = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size(); // traversal every node in each level before go to next level.
            for (int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(curr.left == null && curr.right == null) return result; // return the current level number once get to any leaf node in this level
                if (curr.left != null) {
                    queue.offer(curr.left); // add all next non-null nodes into the queue
                }
                if (curr.right != null){
                    queue.offer(curr.right); // add all next non-null nodes into the queue
                }
            } result++;
        } return result;
    }
}