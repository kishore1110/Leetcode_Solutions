class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Queue<int[]> queue=new LinkedList<>();
       int totalWords=wordList.size();
       int[] visited=new int[totalWords];
       for(int i=0;i<totalWords;i++){
            if(check(beginWord,wordList.get(i))){
                queue.offer(new int[]{i,2});
                visited[i]=1;
            }
       }
       while(!queue.isEmpty()){
            int[] poped=queue.poll();
            int index=poped[0];
            int step=poped[1];
            if(wordList.get(index).equals(endWord)){
                return step;
            }
            for(int i=0;i<totalWords;i++){
                if(visited[i]==0 && check(wordList.get(index),wordList.get(i))){
                    queue.offer(new int[]{i,step+1});
                    visited[i]=1;
                }
            }
       }
       return 0;
    }
    public boolean check(String str1,String str2){
        int mismatch=0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                mismatch++;
            }
            if(mismatch>1)return false;
        }
        return true;
    }
}