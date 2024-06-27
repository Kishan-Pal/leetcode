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
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder();
        List<String> res = new ArrayList<>();
        this.dfs(root, path, res);
        return res;
        
    }
    public void dfs(TreeNode root, StringBuilder path, List<String> res) {
        if(root == null) return;

        int len = path.length();
        path.append(root.val);

        if(root.left == null && root.right == null) {
            res.add(path.toString());
        }
        else {
            path.append("->");
            this.dfs(root.left, path, res);
            this.dfs(root.right, path, res);
        }
        path.setLength(len);
    }
}