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
    public void flatten(TreeNode root) {
        
        if(root == null || root.left == null && root.right == null) return;
        if(root.left == null) {
            flatten(root.right);
            return;
        }
        
        flatten(root.left);
        TreeNode r, cur;
        r = root.right;
        cur = root.left;
        while(cur.right != null) {
            cur = cur.right;
        }
        cur.right = r;
        root.right = root.left;
        root.left = null;
        flatten(r);
        
        
    }
}