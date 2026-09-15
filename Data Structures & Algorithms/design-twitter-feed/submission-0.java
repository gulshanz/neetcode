
class Tweet {
    int id;
    int num;

    Tweet(int tweetId, int num) {
        this.id = tweetId;
        this.num = num;
    }
}

class User {
    int id;
    Set<Integer> following;
    PriorityQueue<Tweet> tweets;

    User(int id) {
        this.id = id;
        this.following = new HashSet<>();
        this.tweets = new PriorityQueue<>(
                (t1, t2) -> Integer.compare(t1.num, t2.num));
    }

    void addFollowing(int followerId) {
        this.following.add(followerId);
    }

    void removeFollowing(int followerId) {
        this.following.remove(Integer.valueOf(followerId));
    }

    void postTweet(int tweetId, int num) {
        Tweet tweet = new Tweet(tweetId, num);
        tweets.offer(tweet);
        if (tweets.size() > 10)
            tweets.poll();
    }

    List<Tweet> getMostRecentTweets() {
        return new ArrayList<>(tweets);
    }
}

class Twitter {

    HashMap<Integer, User> map = new HashMap<>();
    int tweetNum = 0;

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        resolveUser(userId);
        map.get(userId).postTweet(tweetId, tweetNum++);
    }

    public List<Integer> getNewsFeed(int userId) {
        resolveUser(userId);
        User currUser = map.get(userId);

        // get the users to which this user follows
        List<Integer> users = new ArrayList<>(map.get(userId).following);

        // max heap to store all the tweets 
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
                (t1, t2) -> Integer.compare(t2.num, t1.num));

        // adding all the tweets to maxHeap
        for (int i = 0; i < users.size(); i++) {
            User user = map.get(users.get(i));
            maxHeap.addAll(user.getMostRecentTweets());
        }

        // add current user's tweets to maxheap
        maxHeap.addAll(map.get(userId).tweets);

        List<Integer> res = new ArrayList<>();
        int p = 0;

        // retreive most recents
        while (!maxHeap.isEmpty() && p < 10) {
            res.add(maxHeap.poll().id);
            p++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        resolveUser(followerId);
        resolveUser(followeeId);
        map.get(followerId).addFollowing(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        resolveUser(followerId);
        resolveUser(followeeId);
        map.get(followerId).removeFollowing(followeeId);
    }

    public void resolveUser(int userId) {
        if (map.get(userId) == null) {
            map.put(userId, new User(userId));
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

// {1, User()}