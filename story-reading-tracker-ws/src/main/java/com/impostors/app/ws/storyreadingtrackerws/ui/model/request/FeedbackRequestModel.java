package com.impostors.app.ws.storyreadingtrackerws.ui.model.request;

import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.UserDto;

import java.util.Date;

public class FeedbackRequestModel {


    private String feedbackText;
    private boolean feedbackRead;
    private Date createdOn;

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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
