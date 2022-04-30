package com.impostors.app.ws.storyreadingtrackerws.io.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "stories_users")
public class StoryUserEntity implements Serializable {

    private static final long serialVersionUID = -76854760916660252L;
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String storyUserId;

    @Column(nullable=false)
    private int feedbackRate;

    @Column(nullable=false)
    private int gainedPoint;

    @Column(nullable=false)
    private int successRate;

    @Column(nullable=false)
    private Date readOnDate;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name="users_id")
    private UserEntity userDetails;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name="stories_id")
    private StoryEntity storyDetails;


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

    public UserEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserEntity userDetails) {
        this.userDetails = userDetails;
    }

    public StoryEntity getStoryDetails() {
        return storyDetails;
    }

    public void setStoryDetails(StoryEntity storyDetails) {
        this.storyDetails = storyDetails;
    }
}
