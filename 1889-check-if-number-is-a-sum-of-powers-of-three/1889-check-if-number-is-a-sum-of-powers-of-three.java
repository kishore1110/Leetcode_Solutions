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
    // O(log 3 n)
}

    // public boolean backtrack(int n,int power,int currentSum){
    //     if(currentSum==n){
    //         return true;
    //     }
    //     if(currentSum>n || Math.pow(3,power)>n){
    //         return false;
    //     }
    //     return backtrack(n,power+1,currentSum+(int)Math.pow(3,power)) || backtrack(n,power+1,currentSum);
    // }

// time complexity for bactack => 3 power i= n
// taking log 3 on both sides
// i=log 3 n
// tn=> O(2 power log 3 n) which less than n (lot of math behind this)