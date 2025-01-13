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
    int totalSum=0;
    public int sumNumbers(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(root,0);
        return totalSum;
    }
    public void dfs(TreeNode root,int currentNum){
        if(root==null){
            return;
        }
        int num=(currentNum*10)+root.val;
        if(root.left==null && root.right==null){
            totalSum+=num;
            return;
        }
        dfs(root.left,num);
        dfs(root.right,num);
    }
}