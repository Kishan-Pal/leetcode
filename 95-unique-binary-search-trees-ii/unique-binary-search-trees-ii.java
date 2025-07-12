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
    public List<TreeNode> generateTrees(int n) {
        Map<String, List<TreeNode>> memo = new HashMap<>();

        return dfs(1, n, memo);
    }

    public List<TreeNode> dfs(int start, int end, Map<String, List<TreeNode>> memo) {
        String key = start + "-" + end;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        List<TreeNode> treeRoots = new ArrayList<>();
        if(start > end) {
            treeRoots.add(null);
            return treeRoots;
        }

        for(int rootval=start; rootval<=end; rootval++) {
            List<TreeNode> leftTreeRoots = dfs(start, rootval-1, memo);
            List<TreeNode> rightTreeRoots = dfs(rootval+1, end, memo);

            for(TreeNode left: leftTreeRoots) {
                for(TreeNode right: rightTreeRoots) {
                    TreeNode root = new TreeNode(rootval);
                    root.left = left;
                    root.right = right;
                    treeRoots.add(root);
                }
            }
        }
        memo.put(key, treeRoots);
        return treeRoots;
    }
}