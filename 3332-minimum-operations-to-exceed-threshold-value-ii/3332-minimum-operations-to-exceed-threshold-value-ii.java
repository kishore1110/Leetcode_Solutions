class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue=new PriorityQueue<>();
        int minOperations=0;
        for(int value:nums){
            queue.offer((long)value);
        }
        while(queue.peek()<k && queue.size()>1){
            minOperations++;
            long x=queue.poll();
            long y=queue.poll();
            queue.offer((long)x*2+y);
        }
        return minOperations;
    }
}