class Solution {
    public int countPaths(int n, int[][] roads) {
        long[] distance=new long[n];
        long[] count=new long[n];
        HashMap<Integer,ArrayList<long[]>> adj=new HashMap<>();
        for(int[] edge:roads){
            adj.computeIfAbsent(edge[0],k->new ArrayList<>()).add(new long[]{edge[2],edge[1]});
            adj.computeIfAbsent(edge[1],k->new ArrayList<>()).add(new long[]{edge[2],edge[0]});
        }
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->a[0]==b[0]?Long.compare(a[1],b[1]):Long.compare(a[0],b[0]));
        Arrays.fill(distance,Long.MAX_VALUE);
        distance[0]=0;
        count[0]=1;
        long[] temp;
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            temp=pq.poll();
            int node=(int)temp[1];
            long dis=temp[0];
            if(!adj.containsKey(node))continue;
            for(long[] nodes:adj.get(node)){
                int adjNode=(int)nodes[1];
                long disNeed=nodes[0];
                if(dis+disNeed<distance[adjNode]){
                    count[adjNode]=count[node];
                    distance[adjNode]=dis+disNeed;
                    pq.add(new long[]{distance[adjNode],adjNode});
                }
                else if(dis+disNeed==distance[adjNode]){
                    count[adjNode]=(count[adjNode]+count[node])%1000000007;
                }
            }
        }
        count[n-1]%=1000000007;
        return (int)count[n-1];
    }
}