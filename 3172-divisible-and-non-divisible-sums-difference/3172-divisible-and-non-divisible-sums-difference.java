class Solution {
    public int differenceOfSums(int n, int m) {
        // the result they ask is
        // let a=sum of divisible
        // result=(totalSum-a)-a
        // result=totalSum-2*a
        int totalSum=n*(n+1)/2;
        int k=n/m;
        int divisibleSum=m*(k*(k+1)/2);
        return totalSum-2*divisibleSum;
    }
}