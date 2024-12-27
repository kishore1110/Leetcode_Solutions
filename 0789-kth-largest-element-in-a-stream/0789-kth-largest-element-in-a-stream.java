class KthLargest {
    PriorityQueue<Integer> pq;
    int kthLargest;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>((a,b)->Integer.compare(a,b));
        kthLargest=k;
        for(int val:nums){
            pq.offer(val);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size()>kthLargest){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */