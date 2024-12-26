class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveDoller=0;
        int tenDoller=0;
        for(int bill:bills){
            if(bill==5){
                fiveDoller+=1;
            }
            else if(bill==10){
                if(fiveDoller>0){
                    fiveDoller-=1;
                    tenDoller+=1;
                }
                else{
                    return false;
                }
            }
            else{
                if(fiveDoller>0 && tenDoller>0 || fiveDoller>2){
                    if(tenDoller==0){
                       fiveDoller-=3;
                    }
                    else{
                        tenDoller-=1;
                        fiveDoller-=1;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}