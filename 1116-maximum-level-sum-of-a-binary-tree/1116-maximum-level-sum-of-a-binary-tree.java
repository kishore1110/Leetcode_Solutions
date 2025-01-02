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
    public int maxLevelSum(TreeNode root) {
        int level=1;
        int maxLevel=1;
        int maxSum=Integer.MIN_VALUE;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode poped=queue.poll();
                sum+=poped.val;
                if(poped.left!=null){
                    queue.offer(poped.left);
                }
                if(poped.right!=null){
                    queue.offer(poped.right);
                }
            }
            if(sum>maxSum){
                maxSum=sum;
                maxLevel=level;
            }
            level++;
        }
        return maxLevel;
    }
}