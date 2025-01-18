class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        while(n!=1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            int temp=n;
            n=0;
            while(temp>0){
                n+=(temp%10)*(temp%10);
                temp/=10;
            }
        }
        return true;
    }
}