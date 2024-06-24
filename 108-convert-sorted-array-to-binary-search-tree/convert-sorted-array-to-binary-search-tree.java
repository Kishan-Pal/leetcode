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
    public TreeNode arrayToBst(int[] nums, int s, int e) {
        if(s>e){
            return null;
        }
        int mid = (int)(s+e)/2;
        return new TreeNode(
            nums[mid],
            arrayToBst(nums, s, mid-1),
            arrayToBst(nums, mid+1, e)
        );
        

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBst(nums, 0, nums.length-1);
    }
}