class Solution {
    public int compress(char[] chars) {
        Stack<Character> stack=new Stack<>();
        int index=0;
        int count=0;
        for(char ch:chars){
            if(stack.isEmpty() || ch!=stack.peek()){
                if(count>1){
                    String c=String.valueOf(count);
                    for(int i=0;i<c.length();i++){
                        chars[index++]=c.charAt(i);
                    }
                }
                chars[index++]=ch;
                count=1;
                stack.push(ch);
            }
            else if(ch==stack.peek()){
                count++;
            }
        }
        if(count>1){
            String c=String.valueOf(count);
            for(int i=0;i<c.length();i++){
                chars[index++]=c.charAt(i);
            }
        }
        return index;
    }
}