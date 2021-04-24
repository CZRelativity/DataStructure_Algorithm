package middle;

import java.util.*;

public class twitter355 {

    public static void main(String[] args) {
        twitter355 t = new twitter355();
        t.new Twitter().test();
    }

    class Twitter {

        private void test() {
            postTweet(1, 5);
            postTweet(1, 3);
            postTweet(1, 101);
            postTweet(1, 13);
            postTweet(1, 10);
            postTweet(1, 2);
            postTweet(1, 94);
            postTweet(1, 505);
            postTweet(1, 333);
            postTweet(1, 22);
            postTweet(1, 11);
            System.out.println(getNewsFeed(1));
        }

        Map<Integer, User> idUserMap;
        int time;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            //用map来对应用户id和用户对象的注册
            idUserMap = new HashMap<>();
            //由于推特列表排序严格按照时间，用一个++的抽象时间来标记每条推特
            time = 0;
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            User user;
            //如果发推用户没有注册
            if (!idUserMap.containsKey(userId)) {
                user = new User(userId);
                idUserMap.put(userId, user);
            } else {
                user = idUserMap.get(userId);
            }
            //添加推特到当前用户的推特list
            user.tweetList.add(new Tweet(tweetId, time));
            time++;
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            if (!idUserMap.containsKey(userId)) {
                return new ArrayList<>();
            }
            User user = idUserMap.get(userId);
            //由于默认关注了自己，所以直接获取关注Queue就可以
            Deque<Integer> followeeQue = user.followeeQue;
            List<Tweet> tweets = new ArrayList<>();
            for (int id : followeeQue) {
                //list全部添加到list的方法
                tweets.addAll(idUserMap.get(id).tweetList);
            }
            tweets.sort(Comparator.comparingInt(e -> e.time));
            //为了标记time，用了Tweet对象，但是最后需要返回的是List<Integer>
            List<Integer> ret = new ArrayList<>();
            for (int i = tweets.size() - 1, count = 0;
                 i >= 0 && count < 10; i--, count++) {
                ret.add(tweets.get(i).id);
            }
            return ret;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            //不能follow自己
            if (followeeId == followerId) {
                return;
            }
            User user;
            //发起关注者和被关注者如果没有注册
            if (!idUserMap.containsKey(followerId)) {
                user = new User(followerId);
                idUserMap.put(followerId, user);
            } else {
                user = idUserMap.get(followerId);
            }
            if (!idUserMap.containsKey(followeeId)) {
                idUserMap.put(followeeId, new User(followeeId));
            }
            //由于抓取的tweet的时候是抓取用户自身和关注列表的所有tweet，所以把关注列表存到用户自己的对象
            if (!user.followeeQue.contains(followeeId)) {
                user.followeeQue.add(followeeId);
            }
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            //不能取关自己
            if (followeeId == followerId) {
                return;
            }
            //不能通过取关来注册，所以未注册的用户直接返回
            if (!idUserMap.containsKey(followerId)) {
                return;
            }
            User user = idUserMap.get(followerId);
            user.followeeQue.remove(followeeId);
        }
    }

    class User {
        int id;
        //使用deque方便remove
        Deque<Integer> followeeQue;
        List<Tweet> tweetList;

        public User(int id) {
            this.id = id;
            followeeQue = new LinkedList<>();
            tweetList = new ArrayList<>();
            //默认关注自己
            followeeQue.add(this.id);
        }
    }

    class Tweet {
        int id;
        int time;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}
