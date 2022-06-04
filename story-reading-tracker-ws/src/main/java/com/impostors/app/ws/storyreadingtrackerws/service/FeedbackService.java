package com.impostors.app.ws.storyreadingtrackerws.service;

import com.impostors.app.ws.storyreadingtrackerws.shared.dto.FeedbackDto;

import java.util.List;

public interface FeedbackService {

    FeedbackDto createFeedback(FeedbackDto feedbackDto,String storyId);
    List<FeedbackDto> getAllFeedbacks();
    void updateAsChecked(String feedbackId);
}
