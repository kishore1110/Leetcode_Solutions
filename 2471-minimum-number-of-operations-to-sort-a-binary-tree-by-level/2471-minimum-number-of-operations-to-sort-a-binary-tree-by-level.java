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
    public int minimumOperations(TreeNode root) {
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int maxSwaps=0;
        while(!queue.isEmpty()){
            int length=queue.size();
            int[] arr=new int[length];
            for(int i=0;i<length;i++){
                TreeNode pop=queue.poll();
                arr[i]=pop.val;
                if(pop.left!=null){
                    queue.offer(pop.left);
                }
                if(pop.right!=null){
                    queue.offer(pop.right);
                }
            }
            int currentSwap=selectionSort(arr,length);
            maxSwaps+=currentSwap;
        }
        return maxSwaps;
    }
    public int selectionSort(int[] arr1,int length){
        int count=0;
        HashMap<Integer,Integer> arr1map=new HashMap<>();
        for(int i=0;i<length;i++){
            arr1map.put(arr1[i],i);
        }
        int[] arr2=Arrays.copyOf(arr1,length);
        Arrays.sort(arr2);
        for(int i=0;i<length;i++){
            if(arr1[i]!=arr2[i]){
                int index=arr1map.get(arr2[i]);
                int temp=arr1[index];
                arr1[index]=arr1[i];
                arr1[i]=temp;
                arr1map.put(arr1[index],index);
                count++;
            }
        }
        return count;
    }
}