class Twitter {

    Map<Integer, List<Post>> posts;
    Map<Integer, Set<Integer>> follow;
    int time;
    public Twitter() {
        posts = new HashMap();
        follow = new HashMap();
        time = 0;

    }
    
    public void postTweet(int userId, int tweetId) {
        posts.computeIfAbsent(userId, id -> new ArrayList()).add(new Post(time, tweetId));
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Post> feed = new PriorityQueue<>((a,b) -> 
        Integer.compare(a.time, b.time));

        for(int following:follow.getOrDefault(userId, new HashSet<>())) {
            List<Post> cur = posts.getOrDefault(following, new ArrayList());
            for(Post post:cur) {
                feed.add(post);
                if(feed.size()>10) {
                    feed.poll();
                }
            }
        }

        for(Post post:posts.getOrDefault(userId, new ArrayList<>())) {
            feed.add(post);
            if(feed.size()>10) {
                feed.poll();
            }
        }

        LinkedList<Integer> view = new LinkedList();

        while(!feed.isEmpty()) {
            Post top = feed.poll();
            view.addFirst(top.tweetId);
        }
        return view;
    }
    
    public void follow(int followerId, int followeeId) {
        follow.computeIfAbsent(followerId, key -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = follow.get(followerId);
        if(set!=null && set.contains(followeeId)) {
            set.remove(followeeId);
        }
    }
}

class Post {
    int time;
    int tweetId;

    Post(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
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