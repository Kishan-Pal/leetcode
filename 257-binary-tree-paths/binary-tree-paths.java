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
    public void dfs(TreeNode root, String path, List<String> res) {
        if(root.left == null && root.right == null) {
            path = path + root.val;
            res.add(path);
            return;
        }
        path = path + root.val + "->";
        if(root.left != null)
            this.dfs(root.left, path, res);
        if(root.right != null)
            this.dfs(root.right, path, res);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        this.dfs(root, "", res);
        return res;
        
    }
}