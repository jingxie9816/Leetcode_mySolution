class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private void helper(Node root, List<Integer> result){
        if (root == null) return;
        result.add(root.val);
        for (Node i : root.children){
            helper(i, result);
        }
    }
}

