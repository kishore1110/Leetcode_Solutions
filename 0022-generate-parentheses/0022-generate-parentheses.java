class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> para=new ArrayList<>();
        StringBuilder stack=new StringBuilder();
        backtrack(0,0,para,stack,n);
        return para;
    }
    public void backtrack(int openN,int closeN,List<String> para,StringBuilder stack,int n){
        if(openN==closeN && openN==n){
            para.add(stack.toString());
            return;
        }
        if(openN<n){
            stack.append('(');
            backtrack(openN+1,closeN,para,stack,n);
            stack.deleteCharAt(stack.length()-1);
        }
        if(closeN<openN){
            stack.append(')');
            backtrack(openN,closeN+1,para,stack,n);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}