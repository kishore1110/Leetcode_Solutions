class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[][] newArr=new int[arr.length][2];
        int index=0;
        for(int num:arr){
            newArr[index++]=new int[]{num,Math.abs(num-x)};
        }
        Arrays.sort(newArr,(a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        List<Integer> result=new ArrayList<>();
        for(int[] n:newArr){
            result.add(n[0]);
            if(result.size()>=k)break;
        }
        Collections.sort(result);
        return result;
    }
}