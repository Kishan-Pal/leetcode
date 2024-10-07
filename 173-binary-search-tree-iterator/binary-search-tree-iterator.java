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
class BSTIterator {
    private ArrayList<TreeNode> elements = new ArrayList<>();
    private int index = 0;


    public BSTIterator(TreeNode root) {
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNode root) {
        if(root == null) return;
        inorderTraversal(root.left);
        elements.add(root);
        inorderTraversal(root.right);
    }
    
    public int next() {
        return elements.get(index++).val;
    }
    
    public boolean hasNext() {
        return index != elements.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */