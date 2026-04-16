class Twitter {
    Map<Integer, Set<Integer>> followerMap;
    Map<Integer, List<int[]>> tweetsMap;
    int time;
    PriorityQueue<int[]> mostRecentTweets;

    public Twitter() {
        time = 0;
        followerMap = new HashMap<>(); 
        tweetsMap = new HashMap<>();   
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetsMap.containsKey(userId)) {
            tweetsMap.put(userId, new ArrayList<>());
        }

        tweetsMap.get(userId).add(new int[]{time++, tweetId});

        if(!followerMap.containsKey(userId)) {
            followerMap.put(userId, new HashSet<>());
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        mostRecentTweets = new PriorityQueue<>((a,b)-> Integer.compare(b[0], a[0]));

        if(!tweetsMap.containsKey(userId) && !followerMap.containsKey(userId)) return result;
        
        if(tweetsMap.containsKey(userId)) {
            List<int[]> personalTweets = tweetsMap.get(userId);
            for(int[] tweetsWithTime: personalTweets) {
                mostRecentTweets.offer(tweetsWithTime);
            }
        }
        
        Set<Integer> followersForUserId = followerMap.get(userId);
        for(int followeeId: followersForUserId) {
            List<int[]> tweets = tweetsMap.get(followeeId);
            if(!tweets.isEmpty()) {
                for(int[] tweetsWithTime: tweets) {
                    mostRecentTweets.offer(tweetsWithTime);
                }
            }
        }

        while(!mostRecentTweets.isEmpty() && result.size() < 10) {
            result.add(mostRecentTweets.poll()[1]);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if(!followerMap.containsKey(followerId)) {
            followerMap.put(followerId, new HashSet<>());
        }
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        Set<Integer> followeeIdSet = followerMap.get(followerId);
        if(followeeIdSet.contains(followeeId)) {
            followeeIdSet.remove(followeeId);
        }
    }
}
