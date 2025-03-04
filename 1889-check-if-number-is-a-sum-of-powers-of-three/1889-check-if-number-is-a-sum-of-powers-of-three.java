class Solution {
    public boolean checkPowersOfThree(int n) {
        return  backtrack(n,0,0);
    }
    public boolean backtrack(int n,int power,int currentSum){
        if(currentSum==n){
            return true;
        }
        if(currentSum>n || Math.pow(3,power)>n){
            return false;
        }
        return backtrack(n,power+1,currentSum+(int)Math.pow(3,power)) || backtrack(n,power+1,currentSum);
    }
}