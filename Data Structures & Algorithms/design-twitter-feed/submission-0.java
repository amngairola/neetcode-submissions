class Twitter {
    // <user, following >
    HashMap<Integer, ArrayList<Integer>> connections;
    // user and users tweet  : tweet [tweetID , time];
    HashMap<Integer, ArrayList<int[]>> tweets;
    // tweetId , time
    PriorityQueue<int[]> pq;
    int time;

    public Twitter() {
        time = 0;

        tweets = new HashMap<>();
        connections = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        time++;

        // Make sure user exists
        connections.putIfAbsent(userId, new ArrayList<>());
        tweets.putIfAbsent(userId, new ArrayList<>());

        if (!connections.get(userId).contains(userId)) {
            connections.get(userId).add(userId);
        }
        tweets.get(userId).add(new int[] {tweetId, time});
    }

    public List<Integer> getNewsFeed(int userId) {
         pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        connections.putIfAbsent(userId, new ArrayList<>());
        if (!connections.get(userId).contains(userId)) {
            connections.get(userId).add(userId);
        }

        ArrayList<Integer> following = connections.get(userId);

        for (int connectionId : following) {
            if (!tweets.containsKey(connectionId)) {
                continue;
            }

            ArrayList<int[]> tweetByUser = tweets.get(connectionId);

            for (int[] tweet : tweetByUser) {
                pq.offer(tweet);

                if (pq.size() > 10)
                    pq.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] curT = pq.poll();
            ans.add(curT[0]);
        }
        Collections.reverse(ans);

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        connections.putIfAbsent(followerId, new ArrayList<>());
        connections.putIfAbsent(followeeId, new ArrayList<>());

        if (!connections.get(followerId).contains(followeeId)) {
            connections.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (connections.containsKey(followerId)) {
            connections.get(followerId).remove(Integer.valueOf(followeeId));
        }
        connections.get(followerId).remove(Integer.valueOf(followeeId));
    }
}
