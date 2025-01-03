class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs=new int[position.length][2];
        for(int i=0;i<position.length;i++){
            pairs[i]=new int[]{position[i],speed[i]};
        }
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
        int carFleet=0;
        double maxUnit=(double)(target-pairs[pairs.length-1][0])/pairs[pairs.length-1][1];
        for(int i=pairs.length-2;i>=0;i--){
            int pos=pairs[i][0];
            int spd=pairs[i][1];
            double time=(double)(target-pos)/spd;
            if(time<=maxUnit){
                carFleet++;
            }
            else{
                maxUnit=time;
            }
        }
        return pairs.length-carFleet;
    }
}