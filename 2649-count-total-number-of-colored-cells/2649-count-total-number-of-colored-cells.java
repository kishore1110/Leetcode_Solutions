class Solution {
    public long coloredCells(int n) {
        // If we look at the patterns, for n =1 we get 1.
        // For n = 2, we get 5 cells arranged as 1+3+1.
        // For n = 3, we get 13 cells arranged as 1+3+5+3+1.
        // For n = 4, we get 25 cells arranged as 1+3+5+7+5+3+1.

        // To elaborate further, we can rearrange this as:
        // 1+3+5+7
        //    +1+3+5

        // Meaning that for a given n, we are basically finding the sum of first n odd numbers, and adding to it the sum of first(n-1) odd numbers.

        // Sum of first n odd numbers is given by n².
        // Thus, our answer is simply :
        // return (n*n)+(n-1)*(n-1)
        
        return (long)n*n+(long)(n-1)*(n-1);

    }
}