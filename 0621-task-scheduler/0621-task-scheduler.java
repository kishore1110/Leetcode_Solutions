class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] fq=new int[26];
        for(char ch:tasks){
            fq[ch-'A']++;
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int value:fq){
            if(value!=0)maxHeap.offer(value);
        }
        Queue<int[]> queue=new ArrayDeque<>();
        int time=0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int freq=maxHeap.poll()-1;
                if(freq>0){
                    int available=time+n;
                    queue.offer(new int[]{freq,available});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1]==time){
                maxHeap.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}