class Solution {
    public String clearStars(String s) {
        char[] chars=s.toCharArray();
        ArrayList<ArrayList<Integer>> map=new ArrayList<>();
        for(int i=0;i<26;i++){
            map.add(new ArrayList<>());
        }
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='*'){
                for(ArrayList<Integer> value:map){
                    if(value.isEmpty())continue;
                    int index=value.remove(value.size()-1);    
                    chars[index]='*';
                    break;
                }
            }
            else{
                map.get(chars[i]-'a').add(i);
            }
        }
        StringBuilder string=new StringBuilder();
        for(char ch:chars){
            if(ch=='*')continue;
            string.append(ch);
        }
        return string.toString();
    }
}