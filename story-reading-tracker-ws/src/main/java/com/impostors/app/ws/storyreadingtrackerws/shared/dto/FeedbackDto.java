package com.impostors.app.ws.storyreadingtrackerws.shared.dto;



import java.io.Serializable;
import java.util.Date;

public class FeedbackDto implements Serializable {

    private static final long serialVersionUID=4865903039190150223l;
    private long id;
    private String feedbackId;
    private String feedbackText;
    private boolean feedbackRead;
    private UserDto userDetails;
    private StoryDto storyDetails;
    private Date createdOn;

    private float feedbackRate;

    public float getFeedbackRate() {
        return feedbackRate;
    }

    public void setFeedbackRate(float feedbackRate) {
        this.feedbackRate = feedbackRate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public boolean isFeedbackRead() {
        return feedbackRead;
    }

    public void setFeedbackRead(boolean feedbackRead) {
        this.feedbackRead = feedbackRead;
    }

    public UserDto getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDto userDetails) {
        this.userDetails = userDetails;
    }

    public StoryDto getStoryDetails() {
        return storyDetails;
    }

    public void setStoryDetails(StoryDto storyDetails) {
        this.storyDetails = storyDetails;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
