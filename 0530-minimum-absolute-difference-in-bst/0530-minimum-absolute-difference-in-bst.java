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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        int minDiff=Integer.MAX_VALUE;
        inorder(root,list);
        for(int i=0;i<list.size()-1;i++){
            minDiff=Math.min(minDiff,Math.abs(list.get(i)-list.get(i+1)));
        }
        return minDiff;
    }
    public void inorder(TreeNode root,List<Integer> list){
        if(root==null)return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}