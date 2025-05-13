class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD=(int)Math.pow(10,9)+7;
        long[] freq=new long[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        while(t>0){
            long[] temp=new long[26];
            for(int i=0;i<26;i++){
                if(freq[i]>0){
                    if(i==25){
                        temp[0]=(temp[0]+freq[i])%MOD; 
                        temp[1]=(temp[1]+freq[i])%MOD;
                    }
                    else{
                        temp[i+1]=(temp[i+1]+freq[i])%MOD;
                    }
                }
            }
            freq=Arrays.copyOf(temp,26);
            t--;
        }
        long length=0;
        for(int i=0;i<26;i++){
            length=(length+freq[i])%MOD;
        }
        return (int)length%MOD;
    }
}