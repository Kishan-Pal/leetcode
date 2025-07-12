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
    public boolean isValidBST(TreeNode root) {
        int leftMin = Integer.MIN_VALUE;
        int rightMax = Integer.MAX_VALUE;
        return dfsValidate(root, leftMin, rightMax);
    }
    public boolean dfsValidate(TreeNode root, int leftMin, int rightMax) {
        if(root == null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        boolean isValidLeft, isValidRight;
        if(left != null) {
            if(left.val < root.val && left.val >= leftMin) {
                isValidLeft = dfsValidate(left, leftMin, root.val-1);
            }
            else {
                isValidLeft = false;
            }
        }
        else {
            isValidLeft = true;
        }
        if(right != null) {
            if(right.val > root.val && right.val <= rightMax) {
                isValidRight = dfsValidate(right, root.val+1, rightMax);
            }
            else {
                isValidRight = false;
            }
        }
        else {
            isValidRight = true;
        }
        return isValidLeft && isValidRight;
    }
}