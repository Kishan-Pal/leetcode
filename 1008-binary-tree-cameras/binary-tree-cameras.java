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
    public int minCameraCover(TreeNode root) {
        int[] res = new int[1];
        int returnval = dfs(root, res);
        if(returnval == 0) res[0]++;
        return res[0];
    }
    public int dfs(TreeNode root, int[] res) {
        if(root.left == null && root.right == null){
            //res[0]++;
            return 0;
        } 
        int leftreturn = -1, rightreturn = -1;
        if(root.left != null) {
            leftreturn = dfs(root.left, res);
        }
        if(root.right != null) {
            rightreturn = dfs(root.right, res);
        }
        if(leftreturn == 0 || rightreturn == 0) {
            res[0]++;
            return 1;
        }
        if(leftreturn == 1 || rightreturn == 1) {
            return 2;
        }
        if(leftreturn == 2 || rightreturn == 2) {
            //res[0]++;
            return 0;
        }
        return 0;
    }
}