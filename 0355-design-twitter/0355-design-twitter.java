class Twitter {
    HashMap<Integer,HashSet<Integer>> followMap;
    HashMap<Integer,List<int[]>> tweetMap;
    int count=0;
    public Twitter() {
        followMap=new HashMap<>();
        tweetMap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId,k->new ArrayList<>()).add(new int[]{count++,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed=new ArrayList<>();
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        if(tweetMap.get(userId)!=null){
            for(int[] tweet:tweetMap.get(userId)){
                maxHeap.offer(tweet);
            }
        }
        if(followMap.get(userId)!=null){
            for(int followId:followMap.get(userId)){
                if(tweetMap.get(followId)!=null){
                    for(int[] tweet:tweetMap.get(followId)){
                        maxHeap.offer(tweet);
                    }
                }
            }
        }
        while(!maxHeap.isEmpty() && newsFeed.size()<10){
            newsFeed.add(maxHeap.poll()[1]);
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.get(followerId)!=null && followMap.get(followerId).contains(followeeId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */