class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        queue=new LinkedList<>();
    }
    
    public int ping(int t) {
        queue.add(t);
        int limit=t-3000;
        while(queue.peek()<limit){
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */