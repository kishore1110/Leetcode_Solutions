class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result=new ArrayList<>();
        int curr=1;
        while(result.size()<n){
            result.add(curr);
            if(curr*10<=n){
                curr*=10;
            }
            else{
                while(curr%10==9 || curr+1>n){
                    curr/=10;
                }
                curr++;
            }
        }
        return result;
    }
}