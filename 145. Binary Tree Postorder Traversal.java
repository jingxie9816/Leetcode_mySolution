class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postTraversal(root, result);
        return result;
    }

    // need another function to keep track of the result list
    private void postTraversal(TreeNode root, List<Integer> result){
        if (root == null) return;
        postTraversal(root.left, result);
        postTraversal(root.right, result);
        result.add(root.val);
    }
}