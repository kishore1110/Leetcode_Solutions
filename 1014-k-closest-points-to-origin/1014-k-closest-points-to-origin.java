class Solution {
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<element> pq=new PriorityQueue<>();
       int index=0;
        for(int[] point:points){
            int x=point[0]*point[0];
            int y=point[1]*point[1];
            double distace=Math.sqrt(x+y);
            pq.add(new element(index++,distace));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] result=new int[k][2];
        index=0;
        while(pq.size()>0){
            element object=pq.poll();
            int popedIndex=object.index;
            result[index++]=points[popedIndex];
        }
        return result;
    }
}
class element implements Comparable<element>{
    int index;
    double distance;
    public element(int index,double distance){
        this.index=index;
        this.distance=distance;
    }
    @Override
    public int compareTo(element other){
        return Double.compare(other.distance,this.distance);
    }
}