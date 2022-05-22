package com.impostors.app.ws.storyreadingtrackerws.service.impl;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.StoryEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.StoryUserEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.UserEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.StoryRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.StoryUserRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.UserRepository;
import com.impostors.app.ws.storyreadingtrackerws.service.StoryUserService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryUserDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.UserDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.Utils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StoryUserServiceImpl implements StoryUserService {

    @Autowired
    StoryUserRepository storyUserRepository;
    @Autowired
    StoryRepository storyRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    Utils utils;

    @Override
    public StoryUserDto createReadingExperience(StoryUserDto storyUser,String storyId) {
        //TODO If we have performance issue here because of the fetching of nested entities,,, update later  FACEEXP

        if(storyRepository.findByStoryId(storyId)==null){
            throw new RuntimeException("Story not exists.");
        }



        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        //set story from storyId
        StoryEntity storyEntity =storyRepository.findByStoryId(storyId);
        StoryDto storyDto=modelMapper.map(storyEntity,StoryDto.class);
        storyUser.setStoryDetails(storyDto);


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        //we get the email from principal than get the user to update storyuser
        UserEntity userEntity=userRepository.findByEmail(username);
        userEntity.setPoints(userEntity.getPoints()+storyUser.getGainedPoint());
        UserDto userDto=modelMapper.map(userEntity,UserDto.class);

        storyUser.setUserDetails(userDto);

        storyUser.setStoryUserId(utils.generateStoryUserId(30));
        storyUser.setReadOnDate(new Date());

        StoryUserEntity storyUserEntity=modelMapper.map(storyUser,StoryUserEntity.class);
        storyUserEntity.setUserDetails(userEntity);
        storyUserEntity.setStoryDetails(storyEntity);

        StoryUserEntity storedStoryUserDetails=storyUserRepository.save(storyUserEntity);

        StoryUserDto returnValue=modelMapper.map(storedStoryUserDetails,StoryUserDto.class);

        return returnValue;
    }

    @Override
    public List<StoryUserDto> getStoriesOfUser(String userId) {

        List<StoryUserDto> returnValue=new ArrayList<>();

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names


        List<StoryUserEntity> storyUserEntities=storyUserRepository.getReadedStoriesOfUser(userId);

        for(StoryUserEntity storyUserEntity: storyUserEntities){
            returnValue.add(modelMapper.map(storyUserEntity,StoryUserDto.class));

        }


        return returnValue;
    }
}
