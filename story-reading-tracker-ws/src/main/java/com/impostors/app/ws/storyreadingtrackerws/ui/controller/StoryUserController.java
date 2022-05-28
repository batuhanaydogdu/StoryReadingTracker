package com.impostors.app.ws.storyreadingtrackerws.ui.controller;

import com.impostors.app.ws.storyreadingtrackerws.exceptions.StoryServiceException;
import com.impostors.app.ws.storyreadingtrackerws.service.StoryUserService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryUserDto;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.ReadingExperienceRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.ErrorMessages;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.SimpleStoryUserRest;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.StoryRest;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.StoryUserRest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("storiesUsers")
public class StoryUserController {
    @Autowired
    StoryUserService storyUserService;

    @PostMapping(path="/{id}")
    public StoryUserRest createReadingExperience(@RequestBody ReadingExperienceRequestModel readingExperienceDetails,@PathVariable String id) throws Exception
    {
        StoryUserRest returnValue=new StoryUserRest();

        if(id.isEmpty()){
            throw new RuntimeException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }




        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        StoryUserDto storyUserDto=modelMapper.map(readingExperienceDetails,StoryUserDto.class);
        //I took just the storyId. I set the user from principal and get the story from storyId. fill the blanks


        StoryUserDto createdStoryUser=storyUserService.createReadingExperience(storyUserDto,id);
        returnValue=modelMapper.map(createdStoryUser, StoryUserRest.class);


        return returnValue;

    }

    @GetMapping(path="/getStories/{userId}")
    public List<SimpleStoryUserRest> getUserStories(@PathVariable String userId){
        List<SimpleStoryUserRest> returnValue=new ArrayList<>();
        List<StoryUserDto> storyUserDtos=storyUserService.getStoriesOfUser(userId);

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);


        for(StoryUserDto storyUserDto:storyUserDtos) {
            SimpleStoryUserRest simpleStoryUserRestModel=modelMapper.map(storyUserDto,SimpleStoryUserRest.class);
            returnValue.add(simpleStoryUserRestModel);
        }


        return returnValue;
    }




}
