class Solution {
    public int[] minOperations(String boxes) {
        int rightSum=0;
        int rightCount=0;
        for(int i=0;i<boxes.length();i++){
            if(boxes.charAt(i)=='1'){
                rightSum+=i;
                rightCount++;
            }
        }
        int leftSum=0;
        int leftCount=0;
        int[] result=new int[boxes.length()];
        result[0]=rightSum;
        if(boxes.charAt(0)=='1'){
            rightCount--;
            leftCount++;
        }
        for(int i=1;i<result.length;i++){
            int distance=0;
            if(boxes.charAt(i)=='1'){
                rightSum-=i;
                rightCount--;
                distance+=Math.abs((i*rightCount)-rightSum);
                leftSum+=i;
                leftCount++;
            }
            else{
                distance+=Math.abs((i*rightCount)-rightSum);
            }
            if(leftCount>0){
                distance+=Math.abs((i*leftCount)-leftSum);
            }
            result[i]=distance;
        }
        return result;
    }
}