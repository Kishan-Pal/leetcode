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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null && root2 != null) return false;
        if(root1 != null && root2 == null) return false;
        if(root1.val != root2.val) return false;

        if(root1.left == null && root2.left == null) {
            if(root1.right == null && root2.right == null) {
                return true;
            }
            if(flipEquiv(root1.right, root2.right)) return true;
            else return false;
        }
        else if(root1.right == null && root2.right == null) {
            if(flipEquiv(root1.left, root2.left)) return true;
            else return false;
        }
        else if(root1.left == null && root2.right == null) {
            if(flipEquiv(root1.right, root2.left)) return true;
            else return false;
        }
        else if(root1.right == null && root2.left == null) {
            if(flipEquiv(root1.left, root2.right)) return true;
            else return false;
        }
        else {
            if(root1.left == null || root1.right == null || root2.left == null || root2.right == null) {
                return false;
            }
            if(root1.left.val == root2.left.val) {
                if(!flipEquiv(root1.left, root2.left)) return false;
                if(!flipEquiv(root1.right, root2.right)) return false;
                return true;
            }
            if(root1.left.val == root2.right.val) {
                if(!flipEquiv(root1.left, root2.right)) return false;
                if(!flipEquiv(root1.right, root2.left)) return false;
                return true;
            }
            return false;
            
        }

    }
}