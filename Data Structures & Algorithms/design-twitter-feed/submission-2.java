class Twitter {
    Map<Integer, Set<Integer>> follows;
    Map<Integer, List<int[]>> tweets;
    int count;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Set<Integer> follow = new HashSet<>();
        follow.add(userId);
        follow.addAll(follows.getOrDefault(userId, new HashSet<>()));
        for (int id: follow) {
            if (!tweets.containsKey(id) ||tweets.get(id).size() < 1 ) continue;
            int indx = tweets.get(id).size() - 1;
            int[] tweet = tweets.get(id).get(indx);
            minHeap.add(new int[]{tweet[0], tweet[1], id, indx - 1});
        }
        
        while (!minHeap.isEmpty() && newsFeed.size() < 10) {
            int[] cur = minHeap.poll();
            newsFeed.add(cur[1]);
            if (cur[3] >= 0) {
                int[] next = tweets.get(cur[2]).get(cur[3]);
                minHeap.add(new int[]{next[0], next[1], cur[2], cur[3] - 1});
            }
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
