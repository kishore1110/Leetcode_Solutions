class Solution {
    public List<String> stringMatching(String[] words) {
        String joinedString=String.join(" ",words);
        List<String> result=new ArrayList<>();
        for(String word:words){
            if(joinedString.indexOf(word)!=joinedString.lastIndexOf(word)){
                result.add(word);
            }
        }
        return result;
    }
}