class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}


//stack
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stk = new LinkedList<>();

        while(!stk.isEmpty() || root != null){
            while(root != null) {
                result.add(root.val);
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();

            root = root.right;
        }
        return result;
    }
}
