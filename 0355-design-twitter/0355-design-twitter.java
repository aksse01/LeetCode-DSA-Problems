class Twitter {
        /*
        #########################################################################
        #                                                                       #
        #  =============================================                        #
        #                  SIDDARDHA CHILUVERU                                  #
        #  =============================================                        #
        #                                                                       #
        #  Author      : Siddardha Chiluveru                                    #
        #  Description : Solution / Code / Project                              #
        #  Date        : 2026-22-08                                             #
        #                                                                       #
        #########################################################################
        */
    Map<Integer, HashSet<Integer>> follow;
    Map<Integer, ArrayList<int[]>> tweet;
    int time;
    public Twitter() {
        time = 0;
        follow = new HashMap<>();
        tweet = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweet.containsKey(userId)) {
            ArrayList<int[]> k = new ArrayList<>();
            tweet.put(userId, k);
        }
        int[] t = new int[]{time, tweetId};
        time += 1;
        tweet.get(userId).add(t);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        HashSet<Integer> k = follow.getOrDefault(userId, new HashSet<>());
        k.add(userId);
        for (int i : k) 
            if (tweet.containsKey(i))
                for (int[] j : tweet.get(i)) 
                    pq.offer(j);
        while (!pq.isEmpty() && ans.size() != 10) {
            int[] t = pq.poll();
            ans.add(t[1]);
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId)) {
            HashSet<Integer> k = new HashSet<>();
            follow.put(followerId, k);
        }
        follow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId) && follow.get(followerId).contains(followeeId))
            follow.get(followerId).remove(followeeId);
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