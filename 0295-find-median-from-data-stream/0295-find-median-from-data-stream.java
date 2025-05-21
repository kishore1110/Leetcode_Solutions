class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        if(minHeap.size()==0 || num>minHeap.peek()){
            minHeap.offer(num);
        }
        else{
            maxHeap.offer(num);
        }
        while(minHeap.size()-1>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        while(maxHeap.size()-1>minHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()>maxHeap.size()){
            return minHeap.peek();
        }
        else if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        return (double)(maxHeap.peek()+minHeap.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */