class Solution {
    public int[] plusOne(int[] digits) {
        int carry=0;
        for(int i=digits.length-1;i>=0;i--){
            int sum=digits[i]+carry;
            if(i==digits.length-1)sum+=1;
            int actual=sum%10;
            carry=sum/10;
            digits[i]=actual;
        }
        if(carry==0)return digits;
        int[] result=new int[digits.length+1];
        result[0]=carry;
        for(int i=0;i<digits.length;i++){
            result[i+1]=digits[i];
        } 
        return result;
    }
}