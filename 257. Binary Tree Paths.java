class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        builUpPath(root, "", paths);
        return paths;
    }

    private void builUpPath(TreeNode root, String currentPath, List<String> paths){
        if(root != null){
            StringBuffer pathSB = new StringBuffer(currentPath);
            pathSB.append(root.val);
            if (root.left == null && root.right == null){
                paths.add(pathSB.toString());
            } 
            else{
                pathSB.append("->");
                builUpPath(root.left, pathSB.toString(), paths);
                builUpPath(root.right, pathSB.toString(), paths);
            }
        }
    }
}