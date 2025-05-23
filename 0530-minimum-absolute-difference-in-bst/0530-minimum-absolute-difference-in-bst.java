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
    int prev=-1;
    int minDiff=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return minDiff;
        }
        getMinimumDifference(root.left);
        if(prev!=-1){
            minDiff=Math.min(minDiff,root.val-prev);
        }
        prev=root.val;
        getMinimumDifference(root.right);
        return minDiff;
    }
}