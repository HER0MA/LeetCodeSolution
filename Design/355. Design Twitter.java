class Twitter {
    class Tweet {
        int id;
        int time;
        Tweet next;
        
        Tweet(int id) {
            this.id = id;
            time = timestamp ++;
            next = null;
        }
    }
    
    class User {
        int id;
        Set<Integer> followees;
        Tweet tweetHead;
        
        User(int id) {
            this.id = id;
            followees = new HashSet<>();
            followees.add(id);
            tweetHead = null;
        }
        
        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
        
        public void follow(int userId) {
            followees.add(userId);
        }
        
        public void unfollow(int userId) {
            followees.remove(userId);
        }
    }
    
    private int timestamp;
    private Map<Integer, User> userMap;

    /** Initialize your data structure here. */
    public Twitter() {
        timestamp = 0;
        userMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId)) return res;
        Set<Integer> followees = userMap.get(userId).followees;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(userMap.size(), (a,b) -> b.time-a.time);
        for (int followee : followees) {
            Tweet head = userMap.get(followee).tweetHead;
            if (head!=null) {
                pq.offer(head);
            }
        }
        int count = 0;
        while (count<10 && !pq.isEmpty()) {
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            if (tweet.next != null) {
                pq.offer(tweet.next);
            }
            count ++;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId==followeeId) return;
        userMap.get(followerId).unfollow(followeeId);
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