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
    private Stack<TreeNode> stack = new Stack<>();
    private boolean isNull;
    


    public BSTIterator(TreeNode root) {
        if(root == null) this.isNull = true;
        else {
            stack.push(root);
            while(root.left != null) {
                root = root.left;
                stack.push(root);
            }
        }
    }
    
    public int next() {
        TreeNode next = stack.pop();
        int num = next.val;
        if(next.right != null) {
            next = next.right;
            stack.push(next);
            while(next.left != null) {
                next = next.left;
                stack.push(next);
            }
        }
        return num;
    }
    
    public boolean hasNext() {
        if(stack.isEmpty()) return false;
        else return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */