package com.impostors.app.ws.storyreadingtrackerws.ui.controller;


import com.impostors.app.ws.storyreadingtrackerws.exceptions.StoryServiceException;
import com.impostors.app.ws.storyreadingtrackerws.io.document.Contour;
import com.impostors.app.ws.storyreadingtrackerws.service.FaceExperienceService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.*;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.ContourRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.FaceExperienceRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.FeedbackRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.WordMicrophoneRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


    @PutMapping(path="/{faceExperienceId}/microphone")
    public void addWords(@RequestBody WordMicrophoneRequestModel wordMicrophoneDetails, @PathVariable String faceExperienceId) throws Exception
    {

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        WordMicrophoneDto wordMicrophoneDto=modelMapper.map(wordMicrophoneDetails,WordMicrophoneDto.class);


        faceExperienceService.addWords(wordMicrophoneDto,faceExperienceId);

    }



    @PutMapping(path="/{faceExperienceId}/all")
    public void addAllContours(@RequestBody List<ContourRequestModel> contourDetails, @PathVariable String faceExperienceId) throws Exception
    {

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names
        List<ContourDto> contourDtoList=new ArrayList<>();
        for(ContourRequestModel crm: contourDetails){
            ContourDto contourDto=modelMapper.map(crm,ContourDto.class);
            contourDtoList.add(contourDto);
        }



        faceExperienceService.addAllContours(contourDtoList,faceExperienceId);

    }

    @GetMapping(path="/{faceExperienceId}/contours")
    public List<ContourRest> getAllContours(@PathVariable String faceExperienceId){
        List<ContourRest> returnValue=new ArrayList<>();

        List<ContourDto> contourDtos=faceExperienceService.getContoursOfFaceExperience(faceExperienceId);

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);


        for(ContourDto contourDto:contourDtos) {
            ContourRest contourRest=modelMapper.map(contourDto,ContourRest.class);
            returnValue.add(contourRest);
        }

        return returnValue;
    }

    @GetMapping(path="/{faceExperienceId}/microphone")
    public List<WordsMicrophoneRest> getAllWords(@PathVariable String faceExperienceId){
        List<WordsMicrophoneRest> returnValue=new ArrayList<>();

        List<WordMicrophoneDto> wordMicrophoneDtos=faceExperienceService.getWordsOfMicrophone(faceExperienceId);

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);


        for(WordMicrophoneDto wordMicrophoneDto:wordMicrophoneDtos) {
            WordsMicrophoneRest wordsMicrophoneRest=modelMapper.map(wordMicrophoneDto,WordsMicrophoneRest.class);
            returnValue.add(wordsMicrophoneRest);
        }

        return returnValue;
    }

}
