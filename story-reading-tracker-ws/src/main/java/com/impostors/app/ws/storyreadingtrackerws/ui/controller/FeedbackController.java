package com.impostors.app.ws.storyreadingtrackerws.ui.controller;


import com.impostors.app.ws.storyreadingtrackerws.exceptions.StoryServiceException;
import com.impostors.app.ws.storyreadingtrackerws.service.FeedbackService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.FeedbackDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryDto;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.FeedbackRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.StoryRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.ErrorMessages;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.FeedbackRest;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.StoryRest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("feedbacks")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @PostMapping(path="/{storyId}")
    public FeedbackRest createFeedback(@RequestBody FeedbackRequestModel feedbackDetails,@PathVariable String storyId) throws Exception
    {
        FeedbackRest returnValue=new FeedbackRest();

        if(feedbackDetails.getFeedbackText().isEmpty()){
            throw new StoryServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }




        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        FeedbackDto feedbackDto=modelMapper.map(feedbackDetails,FeedbackDto.class);

        FeedbackDto createdFeedback=feedbackService.createFeedback(feedbackDto,storyId);
        returnValue=modelMapper.map(createdFeedback, FeedbackRest.class);


        return returnValue;

    }

    @GetMapping(path = "/getAll")
    public List<FeedbackRest> getFeedbacks()throws Exception
    {
        List<FeedbackRest> returnValue=new ArrayList<>();


        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        List<FeedbackDto> takenFeedbacks=new ArrayList<>();

        takenFeedbacks=feedbackService.getAllFeedbacks();

        for(FeedbackDto feedbackDto:takenFeedbacks){
            returnValue.add(modelMapper.map(feedbackDto,FeedbackRest.class));


        }

        return returnValue;
    }


    @PutMapping(path="/{feedbackId}/checked")
    public void checkFeedback(@PathVariable String feedbackId){

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        feedbackService.updateAsChecked(feedbackId);


    }







}
