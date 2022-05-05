package com.impostors.app.ws.storyreadingtrackerws.ui.controller;

import com.impostors.app.ws.storyreadingtrackerws.exceptions.StoryServiceException;
import com.impostors.app.ws.storyreadingtrackerws.service.StoryService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryDto;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.StoryRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.ErrorMessages;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.StoryRest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stories")
public class StoryController {

    @Autowired
    StoryService storyService;


    @PostMapping
    public StoryRest createStory(@RequestBody StoryRequestModel storyDetails) throws Exception
    {
        StoryRest returnValue=new StoryRest();

        if(storyDetails.getTitle().isEmpty() || storyDetails.getStoryText().isEmpty()){
            throw new StoryServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }




        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        StoryDto storyDto=modelMapper.map(storyDetails,StoryDto.class);

        StoryDto createdCourse=storyService.createStory(storyDto);
        returnValue=modelMapper.map(createdCourse, StoryRest.class);


        return returnValue;

    }

    @PutMapping(path="/{id}")
    public StoryRest updateStory(@RequestBody StoryRequestModel storyDetails,@PathVariable String id)
    {
        StoryRest returnValue=new StoryRest();

        if(storyDetails.getTitle().isEmpty()|| storyDetails.getStoryText().isEmpty()) {
            throw new StoryServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        StoryDto storyDto=modelMapper.map(storyDetails, StoryDto.class);

        StoryDto updatedStory=storyService.updateStory(storyDto,id);

        returnValue=modelMapper.map(updatedStory, StoryRest.class);

        return returnValue;
    }

    @GetMapping(path="/randomStory")
    public StoryRest getRandomStory()
    {
        StoryRest returnValue=new StoryRest();




        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        StoryDto takenStory=storyService.getRandomStory();
        returnValue=modelMapper.map(takenStory, StoryRest.class);


        return returnValue;
    }


}
