class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private void helper(Node root, List<Integer> result){
        if (root == null) return;
        for (Node i : root.children){
            helper(i, result);
        }
        result.add(root.val);
    }
}