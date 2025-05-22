class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> available=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> used=new PriorityQueue<>();
        int usedCount=0;
        int index=0;
        for(int i=0;i<nums.length;i++){
            while(index<queries.length && queries[index][0]==i){
                available.offer(queries[index++][1]);
            }
            if(used.size()<nums[i]){
                while(!available.isEmpty() && available.peek()>=i && used.size()<nums[i]){
                    used.offer(available.poll());
                    usedCount++;
                }
                if(used.size()<nums[i])return -1;  //cannot possible to make 0
            }
            while(!used.isEmpty() && used.peek()<=i){
                used.poll();
            }
        }
        return queries.length-usedCount;
    }
}