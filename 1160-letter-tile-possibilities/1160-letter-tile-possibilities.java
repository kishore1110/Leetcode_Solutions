class Solution {
    int count=-1;
    public int numTilePossibilities(String tiles) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<tiles.length();i++){
            map.put(tiles.charAt(i),map.getOrDefault(tiles.charAt(i),0)+1);
        }
        backtrack(map);
        return count;
    }
    public void backtrack(HashMap<Character,Integer> map){
        count++;
        for(char key:map.keySet()){
            if(map.get(key)>0){
                map.put(key,map.get(key)-1);
                backtrack(map);
                map.put(key,map.get(key)+1);
            }
        }
    }
}