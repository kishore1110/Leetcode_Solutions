class Solution {
    public boolean canChange(String start, String target) {
        int left=0;
        int right=0;
        int limit=-1;
        int startLen=start.length();
        int targetLen=target.length();
        while(left<startLen){
            while(left<startLen && start.charAt(left)=='_')left++;
            while(right<targetLen && target.charAt(right)=='_')right++;
            if(left==startLen && right==targetLen)return true;
            if(left==startLen || right==targetLen || start.charAt(left)!=target.charAt(right))return false;
            if(start.charAt(left)=='L'){
                if(right>left || right<=limit)return false;
            }
            else if(start.charAt(left)=='R'){
                if(right<left)return false;
            }
            limit=right;
            left++;
            right++;
        }
        while(left<startLen && start.charAt(left)=='_')left++;
        while(right<targetLen && target.charAt(right)=='_')right++;
        return left==startLen && right==targetLen; 
    }
}