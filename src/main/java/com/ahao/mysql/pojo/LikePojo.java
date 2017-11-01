package com.ahao.mysql.pojo;

public class LikePojo {

    private String userId;
    private String userName;
    private String fruits;
    private String sports;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getFruits() {
        return fruits;
    }
    public void setFruits(String fruits) {
        this.fruits = fruits;
    }
    public String getSports() {
        return sports;
    }
    public void setSports(String sports) {
        this.sports = sports;
    }
    @Override
    public String toString() {
        return "LikePojo [userId=" + userId + ", userName=" + userName + ", fruits=" + fruits + ", sports=" + sports
                + "]";
    }
    
}
