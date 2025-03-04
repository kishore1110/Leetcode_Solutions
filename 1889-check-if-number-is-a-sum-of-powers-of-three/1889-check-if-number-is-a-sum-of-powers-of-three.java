class Solution {
    public boolean checkPowersOfThree(int n) {
        return check(n,0);
    }
    public boolean check(int n,int reminder){
        if(n==2){
            return false;
        }
        if(n<3 && (reminder==0 || reminder==1)){
            return true;
        }
        else if(n<3 && reminder>1){
            return false;
        }
        if(reminder>1){
            return false;
        }
        return check(n/3,n%3);
    }
}