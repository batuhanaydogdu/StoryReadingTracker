package com.impostors.app.ws.storyreadingtrackerws.ui.controller;


import com.impostors.app.ws.storyreadingtrackerws.exceptions.StoryServiceException;
import com.impostors.app.ws.storyreadingtrackerws.service.FaceExperienceService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.ContourDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.FaceExperienceDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.FeedbackDto;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.ContourRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.FaceExperienceRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.FeedbackRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.ContourRest;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.ErrorMessages;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.FaceExperienceRest;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.FeedbackRest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("faceExperiences")
public class FaceExperienceController {

    @Autowired
    FaceExperienceService faceExperienceService;

    @PostMapping(path="/story/{storyId}")
    public FaceExperienceRest createFaceExperience( @PathVariable String storyId) throws Exception
    {
        FaceExperienceRest returnValue=new FaceExperienceRest();






        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        FaceExperienceDto createdFaceExperience=faceExperienceService.createFaceExperience(storyId);
        returnValue=modelMapper.map(createdFaceExperience, FaceExperienceRest.class);


        return returnValue;

    }
    @PutMapping(path="/{faceExperienceId}")
    public void addContour(@RequestBody ContourRequestModel contourDetails, @PathVariable String faceExperienceId) throws Exception
    {

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        ContourDto contourDto=modelMapper.map(contourDetails,ContourDto.class);


        faceExperienceService.addContour(contourDto,faceExperienceId);





    }

}
