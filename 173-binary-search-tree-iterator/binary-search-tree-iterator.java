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
    ArrayList<TreeNode> inOrder = new ArrayList<>();
    int idx = 0;
    TreeNode pointer = new TreeNode(-1);

    public BSTIterator(TreeNode root) {
        inOrderTraversal( root );
    }
    
    public int next() {
        TreeNode next = inOrder.get( idx++ );
        pointer = next;

        return next.val;
    }
    
    public boolean hasNext() {
        return idx != inOrder.size() ;
    }

    private void inOrderTraversal( TreeNode root )
    {
        if( root == null )
        {
            return;
        }
        inOrderTraversal( root.left );
        inOrder.add( root );
        inOrderTraversal( root.right );
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */