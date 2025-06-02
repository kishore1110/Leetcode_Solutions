class Solution {
    public int minFlips(int a, int b, int c) {
        int count=0;
        while(c>0 ||b>0 || a>0){
            int aBit=0;
            if(a>0){
                aBit=a&1;
                a>>=1;
            }
            int bBit=0;
            if(b>0){
                bBit=b&1;
                b>>=1;
            }
            int cBit=0;
            if(c>0){
                cBit=c&1;
                c>>=1;
            }
            if((aBit|bBit)==cBit)continue;
            if(aBit==1 && bBit==1 && cBit==0)count+=2;
            else count++;
        }
        return count;
    }
}