package com.impostors.app.ws.storyreadingtrackerws.ui.model.response;

import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.UserDto;

import java.util.Date;

public class FeedbackRest {

    private String feedbackId;
    private String feedbackText;
    private boolean feedbackRead;
    private UserDto userDetails;  //later make it rest model of user
    private StoryRest storyDetails;
    private Date createdOn;

    private float feedbackRate;

    public float getFeedbackRate() {
        return feedbackRate;
    }

    public void setFeedbackRate(float feedbackRate) {
        this.feedbackRate = feedbackRate;
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

    public StoryRest getStoryDetails() {
        return storyDetails;
    }

    public void setStoryDetails(StoryRest storyDetails) {
        this.storyDetails = storyDetails;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
