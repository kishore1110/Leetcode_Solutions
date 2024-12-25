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
    public int goodNodes(TreeNode root) {
        List<Integer> goodNodes=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        count(root,max,goodNodes);
        return goodNodes.size();
    }
    public void count(TreeNode root,int max,List<Integer> goodNodes){
        if(root==null){
            return;
        }
        if(root.val>=max)goodNodes.add(root.val);
        count(root.left,Math.max(max,root.val),goodNodes);
        count(root.right,Math.max(max,root.val),goodNodes);
    }
}