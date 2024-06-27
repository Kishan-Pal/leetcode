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
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        path(root, sb, ans);
        return ans;
    }

    void path(TreeNode root, StringBuilder sb, List<String> ans) {

        if(root == null) {
            return;
        }

        int len = sb.length();
        sb.append(root.val);

        if(root.left == null && root.right == null) {
            ans.add(sb.toString());

        } else {
            sb.append("->");
            path(root.left, sb , ans);
            path(root.right, sb, ans);
        }
        sb.setLength(len);
    }
}