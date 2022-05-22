package com.impostors.app.ws.storyreadingtrackerws.service.impl;

import com.impostors.app.ws.storyreadingtrackerws.io.document.Contour;
import com.impostors.app.ws.storyreadingtrackerws.io.document.FaceExperienceDocument;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mongodb.FaceExperienceRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.StoryRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.UserRepository;
import com.impostors.app.ws.storyreadingtrackerws.service.FaceExperienceService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.ContourDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.FaceExperienceDto;
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
public class FaceExperienceServiceImpl implements FaceExperienceService {

    @Autowired
    FaceExperienceRepository faceExperienceRepository;

    @Autowired
    Utils utils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StoryRepository storyRepository;

    @Override
    public FaceExperienceDto createFaceExperience( String storyId) {

        if(storyRepository.findByStoryId(storyId)==null){
            throw new RuntimeException("There is no such a story.");
        }


        String faceExperienceDocumentId=utils.generateFaceExperienceId(31);

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
        FaceExperienceDocument faceExperienceDocument=new FaceExperienceDocument();

        faceExperienceDocument.setUserId(username);
        faceExperienceDocument.setPoints(new ArrayList<Contour>());
        faceExperienceDocument.setStoryId(storyId);
        faceExperienceDocument.setFaceExperienceDocumentId(faceExperienceDocumentId);
        faceExperienceDocument.setReadingDate(new Date());


        FaceExperienceDocument storedFaceExperienceDocument=faceExperienceRepository.save(faceExperienceDocument);


        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        FaceExperienceDto returnValue=modelMapper.map(storedFaceExperienceDocument,FaceExperienceDto.class);

        return returnValue;
    }

    @Override
    public void addContour(ContourDto contourDto, String faceExperienceId) {

        FaceExperienceDocument faceExperienceDocument=faceExperienceRepository.findById(faceExperienceId).get();

        if(faceExperienceDocument==null){
            throw new RuntimeException("There is no such a Reading Face Experience.");
        }
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        Contour contour=modelMapper.map(contourDto,Contour.class);

        faceExperienceDocument.getPoints().add(contour);

        faceExperienceRepository.save(faceExperienceDocument);
    }

    @Override
    public void addAllContours(List<ContourDto> contourDtoList, String faceExperienceId) {
        FaceExperienceDocument faceExperienceDocument=faceExperienceRepository.findById(faceExperienceId).get();

        if(faceExperienceDocument==null){
            throw new RuntimeException("There is no such a Reading Face Experience.");
        }
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        for(ContourDto cd: contourDtoList){
            Contour contour=modelMapper.map(cd,Contour.class);
            faceExperienceDocument.getPoints().add(contour);
        }





        faceExperienceRepository.save(faceExperienceDocument);
    }
}
