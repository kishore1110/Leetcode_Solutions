class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left=0;
        int right=k-1;
        int result=Integer.MAX_VALUE;
        while(right<blocks.length()){
            int count=0;
            for(int i=left;i<=right;i++){
                if(blocks.charAt(i)=='W')count++;
            }
            if(count==0)return 0;
            result=Math.min(count,result);
            left++;
            right++;
        }
        return result;
    }
}