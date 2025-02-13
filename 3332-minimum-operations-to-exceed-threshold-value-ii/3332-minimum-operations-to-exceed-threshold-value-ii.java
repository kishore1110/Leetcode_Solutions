class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        int minOperations=0;
        for(int value:nums){
            if(value<k)queue.offer(value);
        }
        while(!queue.isEmpty()){
            minOperations++;
            int x=queue.poll();
            if(queue.isEmpty())break;
            int y=queue.poll();
            long add=2l*x+y;
            if(add<k)queue.offer((int)add);
        }
        return minOperations;
    }
}