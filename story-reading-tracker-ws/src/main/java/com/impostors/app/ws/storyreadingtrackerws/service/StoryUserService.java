package com.impostors.app.ws.storyreadingtrackerws.service;

import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryUserDto;

import java.util.List;

public interface StoryUserService {
    StoryUserDto createReadingExperience(StoryUserDto storyUser,String storyId);
    List<StoryUserDto> getStoriesOfUser(String userId);

}
