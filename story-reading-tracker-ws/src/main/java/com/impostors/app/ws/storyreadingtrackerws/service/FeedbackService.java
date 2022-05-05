package com.impostors.app.ws.storyreadingtrackerws.service;

import com.impostors.app.ws.storyreadingtrackerws.shared.dto.FeedbackDto;

public interface FeedbackService {

    FeedbackDto createFeedback(FeedbackDto feedbackDto,String storyId);
}
