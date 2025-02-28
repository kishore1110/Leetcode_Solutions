class Solution {
    public String decodeString(String s) {
        Stack<Integer> counter=new Stack<>();
        Stack<StringBuilder> holder=new Stack<>();
        StringBuilder string=new StringBuilder();
        int n=0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                n=n*10+s.charAt(i)-'0';
            }
            else if(s.charAt(i)=='['){
                counter.push(n);
                n=0;
                holder.push(string);
                string=new StringBuilder();
            }
            else if(s.charAt(i)==']'){
                StringBuilder temp=string;
                int count=counter.pop();
                string=holder.pop();
                while(count-->0){
                    string.append(temp);
                }
            }
            else{
                string.append(s.charAt(i));
            }
        }
        return string.toString();
    }
}