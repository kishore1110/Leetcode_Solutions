class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int res=0;
        for(int bit:derived){
            res^=bit;
        }
        return res==0;
    }
}