/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int currIndex=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list=new ArrayList<>();
        dfs(root,list);
        return String.join(",",list);
    }
    public void dfs(TreeNode root,List<String> list){
        if(root==null){
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        dfs(root.left,list);
        dfs(root.right,list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array=data.split(",");
        return deserialize(array);
    }
    public TreeNode deserialize(String[] array){
        if(array[currIndex].equals("N")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.valueOf(array[currIndex]));
        currIndex++;
        node.left=deserialize(array);
        currIndex++;
        node.right=deserialize(array);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));