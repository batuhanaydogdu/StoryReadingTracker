package com.impostors.app.ws.storyreadingtrackerws.service.impl;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.StoryEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.StoryRepository;
import com.impostors.app.ws.storyreadingtrackerws.service.StoryService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.Utils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.security.Security;
import java.util.Date;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    StoryRepository storyRepository;
    @Autowired
    Utils utils;


    @Override
    public StoryDto createStory(StoryDto story) {

        if(storyRepository.findByTitle(story.getTitle())!=null){
            throw new RuntimeException("Record already exists.");
        }

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        StoryEntity storyEntity=modelMapper.map(story,StoryEntity.class);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }


        storyEntity.setStoryId(utils.generateStoryId(30));
        storyEntity.setCreatedOn(new Date());
        storyEntity.setUpdatedOn(new Date());
        storyEntity.setUpdatedBy(username);

        StoryEntity storedStoryDetails=storyRepository.save(storyEntity);

        StoryDto returnValue=modelMapper.map(storedStoryDetails,StoryDto.class);

        return returnValue;
    }

    @Override
    public StoryDto updateStory(StoryDto story, String storyId) {
        StoryEntity storyDetails=storyRepository.findByStoryId(storyId);

        if(story.getStoryText().trim().equals(storyDetails.getStoryText().trim())
        && story.getTitle().trim().equals(storyDetails.getTitle().trim())){
            throw new RuntimeException("Story is not changed.");
        }
        if(story.getTitle()==null){
            throw new RuntimeException("Story title is null.");
        }
        if(story.getStoryText()==null){
            throw new RuntimeException("Story text is null.");
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }


        ModelMapper modelMapper=new ModelMapper();

        storyDetails.setStoryText(story.getStoryText());
        storyDetails.setTitle(story.getTitle());
        storyDetails.setUpdatedBy(username);
        storyDetails.setUpdatedOn(new Date());

        StoryEntity updatedStory=storyRepository.save(storyDetails);
        StoryDto returnValue=modelMapper.map(updatedStory,StoryDto.class);

        return returnValue;
    }

}
