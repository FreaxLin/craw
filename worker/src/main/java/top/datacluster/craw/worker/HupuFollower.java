package top.datacluster.craw.worker;

import java.util.Date;

public class HupuFollower {

    private String name;

    private String userId;

    private String follower;

    private String followerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollowerId() {
        return followerId;
    }

    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }

    public Object[] getSqlObject(){
        return new Object[]{name, userId, follower, followerId, new Date()};
    }
}
