class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char str:tasks){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int value:map.values()){
            maxHeap.offer(value);
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