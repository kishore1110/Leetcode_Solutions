class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs=new int[position.length][2];
        for(int i=0;i<position.length;i++){
            pairs[i]=new int[]{position[i],speed[i]};
        }
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
        int carFleet=0;
        double maxUnit=0;
        for(int i=pairs.length-1;i>=0;i--){
            int pos=pairs[i][0];
            int spd=pairs[i][1];
            double time=(double)(target-pos)/spd;
            if(time>maxUnit){
                carFleet++;
                maxUnit=time;
            }
        }
        return carFleet;
        //better solution
        //     int res = 0;
        // double[] timeArr = new double[target];
        // for (int i = 0; i < position.length; i++)
        //     {
        //         timeArr[position[i]]= (double)(target - position[i]) / speed[i];
        //     }
        //     double prev = 0.0;
        //     for (int i = target-1; i >=0 ; i--)
        //     {
        //         double cur = timeArr[i];
        //         if (cur > prev)
        //         {
        //             prev = cur;
        //             res++;
        //         }
        //     }
        //     return res;   
    }
}