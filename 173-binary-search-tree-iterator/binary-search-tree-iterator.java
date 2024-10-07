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
    //private Stack<TreeNode> stack;
    //private boolean isNull;
    private int[] elements;
    private int i;
    private int index;
    


    public BSTIterator(TreeNode root) {
        i = 0;
        index = 0;
        //stack = new Stack<>();
        elements = new int[100002];
        inorderTraversal(root);
        elements[i] = -1;
    }

    private void inorderTraversal(TreeNode root) {
        if(root == null) return;
        inorderTraversal(root.left);
        elements[i] = root.val;
        i++;
        inorderTraversal(root.right);
    }
    
    public int next() {
        return elements[index++];
    }
    
    public boolean hasNext() {
        if(elements[index] == -1) return false;
        else return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */