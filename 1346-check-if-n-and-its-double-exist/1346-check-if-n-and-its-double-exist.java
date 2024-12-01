class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set=new HashSet<>();
        int count=0;
        for(int value:arr){
            if(value==0)count++;
            set.add(value);
        }
        for(int value:arr){
            if(value%2==0 && set.contains(value/2)){
                if(value!=0)return true;
                else if(count>1)return true;
            }
        }
        return false;
    }
}