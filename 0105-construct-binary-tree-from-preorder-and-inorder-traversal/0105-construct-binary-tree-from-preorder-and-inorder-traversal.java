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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
    }
    public TreeNode build (int[] preorder,int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> inMap){
        
        if(preStart>preEnd || inStart> inEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        
        int mid=inMap.get(preorder[preStart]);
        
        int numsLeft=mid-inStart;
        
        root.left=build(preorder,preStart+1,preStart+numsLeft,inorder,inStart,mid-1,inMap);
        
        root.right=build(preorder,preStart+numsLeft+1,preEnd,inorder,mid+1,inEnd,inMap);
        
        return root;
    }
}