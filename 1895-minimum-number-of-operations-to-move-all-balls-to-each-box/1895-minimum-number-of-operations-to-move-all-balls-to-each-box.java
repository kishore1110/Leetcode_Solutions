class Solution {
    public int[] minOperations(String boxes) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<boxes.length();i++){
            if(boxes.charAt(i)=='1'){
                set.add(i);
            }
        }
        int[] result=new int[boxes.length()];
        for(int i=0;i<result.length;i++){
            int distance=0;
            for(int index:set){
                distance+=Math.abs(index-i);
            }
            result[i]=distance;
        }
        return result;
    }
}