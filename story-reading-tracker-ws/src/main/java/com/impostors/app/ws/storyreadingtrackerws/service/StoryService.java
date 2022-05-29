package com.impostors.app.ws.storyreadingtrackerws.service;

import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryDto;

import java.util.List;

public interface StoryService {

    StoryDto createStory(StoryDto story);
    StoryDto updateStory(StoryDto story,String storyId);
    StoryDto getRandomStory();
    List<StoryDto> getAllStories();
    void removeStory(String storyId);
}
