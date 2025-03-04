class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n>0){
            if(n%3==2){
                return false;
            }
            n/=3;
        }
        return true;
    }
    public boolean backtrack(int n,int power,int currentSum){
        if(currentSum==n){
            return true;
        }
        if(currentSum>n){
            return false;
        }
        return backtrack(n,power+1,currentSum+(int)Math.pow(3,power)) || backtrack(n,power+1,currentSum);
    }
}