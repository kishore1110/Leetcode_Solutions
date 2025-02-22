class Solution {
    public int punishmentNumber(int n) {
        int result=0;
         for(int i=1;i<=n;i++){
            if(isPunishment(0, 0, i, String.valueOf(i*i))){
                result+=i*i;
            }
         }
         return result;
    }
    public boolean isPunishment(int index,int currSum,int target,String value){
        if(index>=value.length() && currSum==target){
            return true;
        }
        for(int j=index;j<value.length();j++){
            String currString=value.substring(index,j+1);
            if(isPunishment(j+1,currSum+Integer.valueOf(currString),target,value)){
                return true;
            }
        }
        return false;
    }
}