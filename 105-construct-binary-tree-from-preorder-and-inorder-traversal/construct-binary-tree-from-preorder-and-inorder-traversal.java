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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, 0, inorder.length);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int pIndex, int iStart, int iEnd) {
        if(iEnd - iStart <= 0) return null;
        TreeNode node = new TreeNode(preorder[pIndex], null, null);
        if(iEnd - iStart == 1) return node;

        int iIndex = -1;
        for(int i=iStart; i<iEnd; i++) {
            if(inorder[i] == preorder[pIndex]) {
                iIndex = i;
                break;
            }
        }
        int numLeftEle = iIndex - iStart;

        node.left = dfs(preorder, inorder, pIndex+1, iStart, iIndex);
        node.right = dfs(preorder, inorder, pIndex+1+numLeftEle, iIndex+1, iEnd);
        return node;
    }
}