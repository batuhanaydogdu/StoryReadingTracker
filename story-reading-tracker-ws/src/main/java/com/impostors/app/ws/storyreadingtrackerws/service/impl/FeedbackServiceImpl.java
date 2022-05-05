package com.impostors.app.ws.storyreadingtrackerws.service.impl;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.FeedbackEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.StoryEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.FeedbackRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.StoryRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.UserRepository;
import com.impostors.app.ws.storyreadingtrackerws.service.FeedbackService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.FeedbackDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.Utils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    StoryRepository storyRepository;
    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    Utils utils;
    @Autowired
    UserRepository userRepository;

    @Override
    public FeedbackDto createFeedback(FeedbackDto feedbackDto, String storyId) {
        if(storyRepository.findByStoryId(storyId)==null){
            throw new RuntimeException("There is no such a story.");
        }


        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        FeedbackEntity feedbackEntity=modelMapper.map(feedbackDto,FeedbackEntity.class);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        if(userRepository.findByEmail(username)==null){
            throw new RuntimeException("There is no such a user.");
        }


        feedbackEntity.setFeedbackId(utils.generateFeedbackId(30));
        feedbackEntity.setCreatedOn(new Date());
        feedbackEntity.setStoryDetails(storyRepository.findByStoryId(storyId));
        feedbackEntity.setUserDetails(userRepository.findByEmail(username));



        FeedbackEntity storedFeedbackDetails=feedbackRepository.save(feedbackEntity);

        FeedbackDto returnValue=modelMapper.map(storedFeedbackDetails,FeedbackDto.class);

        return returnValue;
    }
}
