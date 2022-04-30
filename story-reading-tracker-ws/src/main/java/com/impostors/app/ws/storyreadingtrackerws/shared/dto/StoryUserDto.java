package com.impostors.app.ws.storyreadingtrackerws.shared.dto;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class StoryUserDto implements Serializable {
    private static final long serialVersionUID=4865903039190150223l;
    private long id;

    private String storyUserId;
    private int feedbackRate;
    private int gainedPoint;
    private int successRate;
    private Date readOnDate;
    private UserDto users;
    private StoryDto stories;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStoryUserId() {
        return storyUserId;
    }

    public void setStoryUserId(String storyUserId) {
        this.storyUserId = storyUserId;
    }

    public int getFeedbackRate() {
        return feedbackRate;
    }

    public void setFeedbackRate(int feedbackRate) {
        this.feedbackRate = feedbackRate;
    }

    public int getGainedPoint() {
        return gainedPoint;
    }

    public void setGainedPoint(int gainedPoint) {
        this.gainedPoint = gainedPoint;
    }

    public int getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(int successRate) {
        this.successRate = successRate;
    }

    public Date getReadOnDate() {
        return readOnDate;
    }

    public void setReadOnDate(Date readOnDate) {
        this.readOnDate = readOnDate;
    }

    public UserDto getUsers() {
        return users;
    }

    public void setUsers(UserDto users) {
        this.users = users;
    }

    public StoryDto getStories() {
        return stories;
    }

    public void setStories(StoryDto stories) {
        this.stories = stories;
    }
}
