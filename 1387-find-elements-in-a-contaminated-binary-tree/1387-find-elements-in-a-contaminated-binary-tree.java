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
class FindElements {
    HashSet<Integer> set=new HashSet<>();
    public FindElements(TreeNode root) {
        initialize(root);
    }
    public boolean find(int target) {
        return set.contains(target);
    }
    public void initialize(TreeNode root){
        if(root==null){
            return;
        }
        if(root.val==-1)root.val=0;
        set.add(root.val);
        if(root.left!=null)root.left.val=(root.val*2)+1;
        if(root.right!=null)root.right.val=(root.val*2)+2;
        initialize(root.left);
        initialize(root.right);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */