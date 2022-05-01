package com.impostors.app.ws.storyreadingtrackerws.ui.model.response;

import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryDto;

import java.util.Date;

public class SimpleStoryUserRest {
    private String storyUserId;
    private int feedbackRate;
    private int gainedPoint;
    private int successRate;
    private Date readOnDate;
    private StoryDto storyDetails;


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

    public StoryDto getStoryDetails() {
        return storyDetails;
    }

    public void setStoryDetails(StoryDto storyDetails) {
        this.storyDetails = storyDetails;
    }
}
